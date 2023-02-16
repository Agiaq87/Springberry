package it.giaquinto.springberry.controller.base

import it.giaquinto.springberry.controller.SpringBerryBaseController
import it.giaquinto.springberry.model.http.HttpRequest
import it.giaquinto.springberry.model.security.SecurityLevel
import it.giaquinto.springberry.model.specific.InstanceProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldBaseController : SpringBerryBaseController() {
    override fun ID(): String {
        return HelloWorldBaseController::class.java.name
    }

    override fun controllerAcceptedRequest(): Array<HttpRequest> =
        arrayOf(
            HttpRequest.GET
        )

    @GetMapping(path = ["hello"])
    fun hello(): InstanceProperties {
        return InstanceProperties(SecurityLevel.ADMIN)
    }
}