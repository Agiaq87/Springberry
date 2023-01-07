package it.giaquinto.springberry.controller.implementation;

import it.giaquinto.springberry.controller.SpringBerryController;
import it.giaquinto.springberry.model.http.HttpRequest;
import it.giaquinto.springberry.model.math.NumberRepresentation;
import it.giaquinto.springberry.model.math.number.BigIntegerNumberRepresentation;
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

    @GetMapping(path = "to-all-base/{value}")
    public NumberRepresentation toAllBase(@PathVariable final String value) {
        try {
            return getMathUtils().toAllBase(Long.decode(value));
        } catch (final NumberFormatException numberFormatException) {
            return null;
        }
    }

    @GetMapping(path = "factorial/{value}")
    public NumberRepresentation factorial(@PathVariable final String value) {
        try {
            return getMathUtils().toAllBase(getMathUtils().factorial(Long.decode(value)));
        } catch (final NumberFormatException numberFormatException) {
            return null;
        }
    }


}
