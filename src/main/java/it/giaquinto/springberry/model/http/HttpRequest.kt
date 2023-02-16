package it.giaquinto.springberry.model.http

import org.springframework.web.bind.annotation.RequestMethod

enum class HttpRequest {
    GET, HEAD, POST, PUT, DELETE, OPTIONS, TRACE, PATCH;

    companion object {
        operator fun get(toConvert: HttpRequest): RequestMethod =
            when (toConvert) {
                GET -> RequestMethod.GET
                HEAD -> RequestMethod.HEAD
                POST -> RequestMethod.POST
                PUT -> RequestMethod.PUT
                DELETE -> RequestMethod.DELETE
                OPTIONS -> RequestMethod.OPTIONS
                TRACE -> RequestMethod.TRACE
                PATCH -> RequestMethod.PATCH
            }
    }
}