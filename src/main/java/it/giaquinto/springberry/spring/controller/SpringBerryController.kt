package it.giaquinto.springberry.spring.controller

import it.giaquinto.springberry.spring.configuration.Identifier
import org.springframework.web.bind.annotation.GetMapping

interface SpringBerryController<T> {

    val identifier: Identifier

    fun defaultResponse(): T
}