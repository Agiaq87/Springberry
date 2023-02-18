package it.giaquinto.springberry.controller.base;

import it.giaquinto.springberry.controller.SpringBerryBaseController;
import it.giaquinto.springberry.spring.model.http.HttpRequest;
import it.giaquinto.springberry.spring.model.math.NumberRepresentation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class MathCalculatorBaseController extends SpringBerryBaseController {
    @Override
    public String ID() {
        return MathCalculatorBaseController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[] {
                HttpRequest.GET
        };
    }

    /*@GetMapping(path = "math/to-hex/{value}")
    public String toHex(@PathVariable final String value) {
        try {
            return getMathUtils().toHex(Long.decode(value));
        } catch (final NumberFormatException numberFormatException) {
            return "Not A Number";
        }
    }

    @GetMapping(path = "math/to-octal/{value}")
    public String toOctal(@PathVariable final String value) {
        try {
            return getMathUtils().toOctal(Long.decode(value));
        } catch (final NumberFormatException numberFormatException) {
            return "Not A Number";
        }
    }

    @GetMapping(path = "math/to-binary/{value}")
    public String toBinary(@PathVariable final String value) {
        try {
            return getMathUtils().toBinary(Long.decode(value));
        } catch (final NumberFormatException numberFormatException) {
            return "Not A Number";
        }
    }

    @GetMapping(path = "math/to-all-base/{value}")
    public NumberRepresentation toAllBase(@PathVariable final String value) {
        try {
            return getMathUtils().toAllBase(Long.decode(value));
        } catch (final NumberFormatException numberFormatException) {
            return null;
        }
    }

    @GetMapping(path = "math/factorial/{value}")
    public NumberRepresentation factorial(@PathVariable final String value) {
        try {
            return getMathUtils().toAllBase(getMathUtils().factorial(Long.decode(value)));
        } catch (final NumberFormatException numberFormatException) {
            return null;
        }
    }*/

}
