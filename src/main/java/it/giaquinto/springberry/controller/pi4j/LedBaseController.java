package it.giaquinto.springberry.controller.pi4j;

import it.giaquinto.springberry.controller.SpringBerryPi4JBaseController;
import it.giaquinto.springberry.model.http.HttpRequest;
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


}
