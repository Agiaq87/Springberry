package it.giaquinto.springberry.controller.base;

import it.giaquinto.springberry.controller.SpringBerryBaseController;
import it.giaquinto.springberry.spring.model.http.HttpRequest;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class NoteBaseController extends SpringBerryBaseController {
    @Override
    public String ID() {
        return NoteBaseController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[] {
                HttpRequest.GET,
                HttpRequest.POST
        };
    }
}
