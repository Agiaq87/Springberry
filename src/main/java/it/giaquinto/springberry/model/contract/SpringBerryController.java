package it.giaquinto.springberry.model.contract;

import it.giaquinto.springberry.http.HttpRequest;

public interface SpringBerryController {

    /**
     * Get ID of a specific controller
     * It's associated to Controller Class name
     * @return
     */
    String ID();

    /**
     * Specific the accepted Http Method for the controller
     * @return HttpRequest[]
     */
    HttpRequest[] controllerAcceptedRequest();
}
