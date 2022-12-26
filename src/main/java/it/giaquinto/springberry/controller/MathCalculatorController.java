package it.giaquinto.springberry.controller;

import it.giaquinto.springberry.model.contract.SpringBerryController;
import it.giaquinto.springberry.model.http.HttpRequest;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class MathCalculatorController implements SpringBerryController {
    @Override
    public String ID() {
        return MathCalculatorController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[] {
                HttpRequest.GET
        };
    }


}