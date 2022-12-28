package it.giaquinto.springberry.controller;

import it.giaquinto.springberry.model.http.HttpRequest;
import it.giaquinto.springberry.utils.math.MathUtils;
import it.giaquinto.springberry.utils.string.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class SpringBerryController {

    @Autowired
    public StringUtils stringUtils;

    @Autowired
    public MathUtils mathUtils;

    public abstract String ID();

    /**
     * Specific the accepted Http Method for the controller
     * @return HttpRequest[]
     */
    public abstract HttpRequest[] controllerAcceptedRequest();
}
