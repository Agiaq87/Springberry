package it.giaquinto.springberry.controller.implementation;

import com.pi4j.Pi4J;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;
import it.giaquinto.springberry.controller.SpringBerryController;
import it.giaquinto.springberry.controller.SpringBerryPi4jController;
import it.giaquinto.springberry.model.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController extends SpringBerryPi4jController {
    @Override
    public String ID() {
        return LedController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[] {
                HttpRequest.GET
        };
    }

    @GetMapping(path = "/led")
    public boolean led() {
        System.out.println("Simple LED app started ...");

        try {
            setupPin("LED", 22).high();
        } catch (final Exception e) {
            return false;
        }

        return true;
    }
}
