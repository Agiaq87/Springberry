package it.giaquinto.springberry.controller.base

import it.giaquinto.springberry.controller.SpringBerryBaseController
import it.giaquinto.springberry.model.http.HttpRequest
import org.springframework.web.bind.annotation.RestController

@RestController
class NoteBaseController : SpringBerryBaseController() {
    override fun ID(): String {
        return NoteBaseController::class.java.name
    }

    override fun controllerAcceptedRequest(): Array<HttpRequest> {
        return arrayOf(
            HttpRequest.GET,
            HttpRequest.POST
        )
    }
}