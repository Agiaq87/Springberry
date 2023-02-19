package it.giaquinto.springberry.controller.pi4j;

import com.pi4j.provider.Provider;
import it.giaquinto.springberry.controller.SpringBerryPi4JBaseController;
import it.giaquinto.springberry.model.raspberry.component.RaspBerryLedComponent;
import it.giaquinto.springberry.model.raspberry.pin.RaspberryEnumPin;
import it.giaquinto.springberry.spring.model.http.HttpRequest;
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
        return getPi4j().getProviders();
    }

    @GetMapping(path = "gpio/{pin}")
    public String blinkLed(@PathVariable final int pin) {
        if (RaspberryEnumPin.haveRelativePin(pin)) {
            getPi4j().getRaspBerryLedComponent(RaspberryEnumPin.fromInt(pin)).thenAccept(RaspBerryLedComponent::on);
            return Integer.toString(pin);
        } else {
            return "Invalid pin inserted";
        }
    }
}
