package it.giaquinto.springberry.controller.pi4j;

import com.pi4j.provider.Provider;
import it.giaquinto.springberry.component.SpringBerryLoggerComponent;
import it.giaquinto.springberry.controller.SpringBerryPi4JBaseController;
import it.giaquinto.springberry.model.http.HttpRequest;
import it.giaquinto.springberry.model.log.LogMessageFactory;
import it.giaquinto.springberry.model.raspberry.pin.RaspberryPin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public final class GPIOBaseController extends SpringBerryPi4JBaseController {

    @Override
    public String ID() {
        return GPIOBaseController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[] {
                HttpRequest.GET
        };
    }

    @GetMapping(path = "providers")
    public Map<String, Provider> providers() {
        return getPi4JComponent().getProviders();
    }

    @GetMapping(path = "gpio/{pin}")
    public String blinkLed(@PathVariable final int pin) {
        if (RaspberryPin.haveRelativePin(pin)) {
            getPi4JComponent().getRaspBerryLedComponent(RaspberryPin.fromInt(pin)).thenAccept(led -> {
                led.on();
                SpringBerryLoggerComponent.instance().writeLog(
                        LogMessageFactory.Pin.d(
                                String.format("Address pin: %d", led.getAddress().getPin())
                        )
                );
            });
            return Integer.toString(pin);
        } else {
            return "Invalid pin inserted";
        }
    }
}
