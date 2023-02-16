package it.giaquinto.springberry.controller.base

import it.giaquinto.springberry.controller.SpringBerryBaseController
import it.giaquinto.springberry.model.http.HttpRequest
import it.giaquinto.springberry.model.math.NumberRepresentation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MathCalculatorBaseController : SpringBerryBaseController() {
    override fun ID(): String {
        return MathCalculatorBaseController::class.java.name
    }

    override fun controllerAcceptedRequest(): Array<HttpRequest> {
        return arrayOf(
            HttpRequest.GET
        )
    }

    @GetMapping(path = ["math/to-hex/{value}"])
    fun toHex(@PathVariable value: String?): String {
        return try {
            mathUtils.toHex(java.lang.Long.decode(value))
        } catch (numberFormatException: NumberFormatException) {
            "Not A Number"
        }
    }

    @GetMapping(path = ["math/to-octal/{value}"])
    fun toOctal(@PathVariable value: String?): String {
        return try {
            mathUtils.toOctal(java.lang.Long.decode(value))
        } catch (numberFormatException: NumberFormatException) {
            "Not A Number"
        }
    }

    @GetMapping(path = ["math/to-binary/{value}"])
    fun toBinary(@PathVariable value: String?): String {
        return try {
            mathUtils.toBinary(java.lang.Long.decode(value))
        } catch (numberFormatException: NumberFormatException) {
            "Not A Number"
        }
    }

    @GetMapping(path = ["math/to-all-base/{value}"])
    fun toAllBase(@PathVariable value: String?): NumberRepresentation? {
        return try {
            mathUtils.toAllBase(java.lang.Long.decode(value))
        } catch (numberFormatException: NumberFormatException) {
            null
        }
    }

    @GetMapping(path = ["math/factorial/{value}"])
    fun factorial(@PathVariable value: String?): NumberRepresentation? {
        return try {
            mathUtils.toAllBase(mathUtils.factorial(java.lang.Long.decode(value)))
        } catch (numberFormatException: NumberFormatException) {
            null
        }
    }
}