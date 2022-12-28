package it.giaquinto.springberry.controller.implementation;

import it.giaquinto.springberry.controller.SpringBerryController;
import it.giaquinto.springberry.model.http.HttpRequest;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class NoteController extends SpringBerryController {
    @Override
    public String ID() {
        return NoteController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[] {
                HttpRequest.GET,
                HttpRequest.POST
        };
    }
}
