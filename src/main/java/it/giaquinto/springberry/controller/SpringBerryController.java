package it.giaquinto.springberry.controller;

import it.giaquinto.springberry.model.http.HttpRequest;
import it.giaquinto.springberry.component.MathComponent;
import it.giaquinto.springberry.component.StringComponent;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class SpringBerryController {

    private StringComponent stringComponent;

    private MathComponent mathComponent;

    public final StringComponent getStringUtils() {
        return stringComponent;
    }

    @Autowired
    public final void setStringUtils(final StringComponent stringComponent) {
        this.stringComponent = stringComponent;
    }

    public final MathComponent getMathUtils() {
        return mathComponent;
    }

    @Autowired
    public final void setMathUtils(final MathComponent mathComponent) {
        this.mathComponent = mathComponent;
    }


    public abstract String ID();

    /**
     * Specific the accepted Http Method for the controller
     * @return HttpRequest[]
     */
    public abstract HttpRequest[] controllerAcceptedRequest();
}
