package it.giaquinto.springberry.controller.pi4j;

import com.pi4j.provider.Provider;
import it.giaquinto.springberry.controller.SpringBerryPi4JBaseController;
import it.giaquinto.springberry.model.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public final class GPIOBaseController extends SpringBerryPi4JBaseController {

    @Override
    public String ID() {
        return GPIOBaseController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[] {
                HttpRequest.GET
        };
    }

    @GetMapping(path = "providers")
    public Map<String, Provider> providers() {
        return getPi4JComponent().getProviders();
    }
}
