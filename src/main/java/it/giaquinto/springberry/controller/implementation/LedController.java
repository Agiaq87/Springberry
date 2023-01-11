package it.giaquinto.springberry.controller.implementation;

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


}
