package it.giaquinto.springberry.controller.pi4j;

import it.giaquinto.springberry.controller.SpringBerryPi4JBaseController;
import it.giaquinto.springberry.model.http.HttpRequest;
import it.giaquinto.springberry.model.raspberry.RaspberryPin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedBaseController extends SpringBerryPi4JBaseController {
    @Override
    public String ID() {
        return LedBaseController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[] {
                HttpRequest.GET
        };
    }

    @GetMapping(path = "led/{pin}")
    public String blinkLed(@PathVariable final int pin) {
        if (RaspberryPin.haveRelativePin(pin)) {
            getPi4JComponent().getRaspBerryLedComponent(RaspberryPin.fromInt(pin)).on();
            return Integer.toString(pin);
        } else {
            return "Invalid pin inserted";
        }
    }
}