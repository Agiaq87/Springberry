package it.giaquinto.springberry.spring.controller.utils

import it.giaquinto.springberry.model.math.NumberRepresentation
import it.giaquinto.springberry.spring.bean.springberrybean.utils.Mathematics
import it.giaquinto.springberry.spring.configuration.Identifier
import it.giaquinto.springberry.spring.configuration.RestRadix
import it.giaquinto.springberry.spring.configuration.SpringBerryConfiguration
import it.giaquinto.springberry.spring.controller.SpringBerryController
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger

@RestController
class MathController : SpringBerryController<Mathematics> {

    private val mathematics: Mathematics by lazy {
        AnnotationConfigApplicationContext(SpringBerryConfiguration::class.java).getBean("mathUtils") as Mathematics
    }
    override val identifier: Identifier
        get() = this.javaClass.packageName
    override val uniqueRestRadix: RestRadix
        get() = MathController.uniqueRestRadix

    @GetMapping(MathController.uniqueRestRadix)
    override fun defaultResponse(): Mathematics = mathematics

    @GetMapping("${MathController.uniqueRestRadix}/hex/{value}")
    fun toHex(@PathVariable value: String?): String =
        try {
            mathematics.toHex(java.lang.Long.decode(value))
        } catch (numberFormatException: NumberFormatException) {
            "Not A Number"
        }

    @GetMapping("${MathController.uniqueRestRadix}/octal/{value}")
    fun toOctal(@PathVariable value: String?): String =
        try {
            mathematics.toOctal(java.lang.Long.decode(value))
        } catch (numberFormatException: NumberFormatException) {
            "Not A Number"
        }

    @GetMapping("${MathController.uniqueRestRadix}/binary/{value}")
    fun toBinary(@PathVariable value: String?): String =
        try {
            mathematics.toBinary(java.lang.Long.decode(value))
        } catch (numberFormatException: NumberFormatException) {
            "Not A Number"
        }

    @GetMapping("${MathController.uniqueRestRadix}/all/{value}")
    fun toAllBase(@PathVariable value: String?): List<Any?> =
        listOf(
            try {
                value?.toBigInteger()?.let { mathematics.toAllBase(it) } ?: run { "Not a number" }
            } catch (_: NumberFormatException) {
                null
            }
        )

    @GetMapping("${MathController.uniqueRestRadix}/factorial/{value}")
    fun factorial(@PathVariable value: String?): List<Any?> =
        listOf(
            try {
                value?.toBigInteger()?.let { mathematics.factorial(it) } ?: run { "Not a number" }
            } catch (_: NumberFormatException) {
                null
            }
        )

    @GetMapping("${MathController.uniqueRestRadix}/sqrt/{value}")
    fun sqrt(@PathVariable value: String?): List<Any?> =
        listOf(
            try {
                value?.toBigInteger()?.let { mathematics.sqrt(it) } ?: run { "Not a number" }
            } catch (_: NumberFormatException) {
                null
            }
        )

    companion object {
        const val uniqueRestRadix: RestRadix = "math"
    }
}