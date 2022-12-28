package it.giaquinto.springberry.controller.implementation;

import com.pi4j.Pi4J;
import it.giaquinto.springberry.controller.SpringBerryController;
import it.giaquinto.springberry.model.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfig;

@RestController
public class LedController extends SpringBerryController {
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

        var pi4j = Pi4J.newAutoContext();

        return true;
    }
}
