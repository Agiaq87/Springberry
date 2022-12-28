package it.giaquinto.springberry.controller.implementation;

import it.giaquinto.springberry.controller.SpringBerryController;
import it.giaquinto.springberry.model.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class MathCalculatorController extends SpringBerryController {
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

    @GetMapping(path = "to-hex/{value}")
    public String toHex(@PathVariable final String value) {
        try {
            return getMathUtils().toHex(Long.decode(value));
        } catch (final NumberFormatException numberFormatException) {
            return "Not A Number";
        }
    }

    @GetMapping(path = "to-octal/{value}")
    public String toOctal(@PathVariable final String value) {
        try {
            return getMathUtils().toOctal(Long.decode(value));
        } catch (final NumberFormatException numberFormatException) {
            return "Not A Number";
        }
    }

    @GetMapping(path = "to-binary/{value}")
    public String toBinary(@PathVariable final String value) {
        try {
            return getMathUtils().toBinary(Long.decode(value));
        } catch (final NumberFormatException numberFormatException) {
            return "Not A Number";
        }
    }

    @GetMapping(path = "factorial/{value}")
    public String factorial(@PathVariable final String value) {
        try {
            return "" + getMathUtils().factorial(Long.decode(value));
        } catch (final NumberFormatException numberFormatException) {
            return "Not A Number";
        }
    }
}
