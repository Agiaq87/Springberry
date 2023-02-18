package it.giaquinto.springberry.spring.controller

import it.giaquinto.springberry.spring.model.http.HttpRequest
import it.giaquinto.springberry.spring.configuration.Identifier
import it.giaquinto.springberry.spring.configuration.Rest
import it.giaquinto.springberry.spring.configuration.RestRadix
import it.giaquinto.springberry.spring.model.http.ApiResult

interface SpringBerryController<T> {

    val identifier: Identifier

    val uniqueRestRadix: RestRadix



    fun defaultResponse(): ApiResult<T>

    fun controllerAcceptedMethod(): ApiResult<Array<HttpRequest?>?> =
        ApiResult.Success(_data = arrayOf(HttpRequest.GET))

    companion object {
        const val radixControllerAcceptedRequest: Rest = "httpAcceptedMethod"
    }

}