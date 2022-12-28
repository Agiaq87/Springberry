package it.giaquinto.springberry.controller.implementation;

import it.giaquinto.springberry.controller.SpringBerryController;
import it.giaquinto.springberry.model.http.HttpRequest;
import it.giaquinto.springberry.model.security.SecurityLevel;
import it.giaquinto.springberry.model.specific.InstanceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HelloWorldController extends SpringBerryController {

    @Override
    public String ID() {
        return HelloWorldController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[]{
                HttpRequest.GET,
        };
    }

    @GetMapping(path = "hello")
    public InstanceProperties hello() {
        return new InstanceProperties(SecurityLevel.ADMIN);
    }
}
