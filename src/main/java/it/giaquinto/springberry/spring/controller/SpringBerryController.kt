package it.giaquinto.springberry.spring.controller

import it.giaquinto.springberry.spring.configuration.Identifier
import it.giaquinto.springberry.spring.configuration.RestRadix
import org.springframework.web.bind.annotation.GetMapping

interface SpringBerryController<T> {

    val identifier: Identifier

    val uniqueRestRadix: RestRadix

    fun defaultResponse(): T
}