package it.giaquinto.springberry.controller;

import it.giaquinto.springberry.http.HttpRequest;
import it.giaquinto.springberry.model.contract.SpringBerryController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class CalculatorController implements SpringBerryController {
    @Override
    public String ID() {
        return CalculatorController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[] {
                HttpRequest.GET
        };
    }
}
