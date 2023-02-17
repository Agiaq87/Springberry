package it.giaquinto.springberry.spring.controller

import it.giaquinto.springberry.model.http.HttpRequest
import it.giaquinto.springberry.spring.configuration.Identifier
import it.giaquinto.springberry.spring.configuration.Rest
import it.giaquinto.springberry.spring.configuration.RestRadix

interface SpringBerryController<T> {

    val identifier: Identifier

    val uniqueRestRadix: RestRadix



    fun defaultResponse(): T

    fun controllerAcceptedMethod(): Array<HttpRequest?> = arrayOf(
        HttpRequest.GET
    )

    companion object {
        const val radixControllerAcceptedRequest: Rest = "httpAcceptedMethod"
    }

}