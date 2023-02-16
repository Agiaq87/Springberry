package it.giaquinto.springberry.controller

import it.giaquinto.springberry.component.MathComponent
import it.giaquinto.springberry.component.StringComponent
import it.giaquinto.springberry.model.http.HttpRequest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

abstract class SpringBerryBaseController {
    @set:Autowired
    lateinit var stringUtils: StringComponent

    @set:Autowired
    lateinit var mathUtils: MathComponent
    val logger = LoggerFactory.getLogger(this.javaClass)
    abstract fun ID(): String?

    /**
     * Specific the accepted Http Method for the controller
     * @return HttpRequest[]
     */
    abstract fun controllerAcceptedRequest(): Array<HttpRequest>
}