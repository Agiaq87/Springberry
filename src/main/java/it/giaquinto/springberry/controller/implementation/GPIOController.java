package it.giaquinto.springberry.controller.implementation;

import com.pi4j.platform.Platform;
import com.pi4j.provider.Provider;
import it.giaquinto.springberry.controller.SpringBerryPi4jController;
import it.giaquinto.springberry.model.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public final class GPIOController extends SpringBerryPi4jController {

    @Override
    public String ID() {
        return GPIOController.class.getName();
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

    @GetMapping(path = "/platform")
    public Platform platform() {
        return getPi4JComponent().getPlatform();
    }
}
