package it.giaquinto.springberry.spring.controller.utils

import it.giaquinto.springberry.spring.bean.springberrybean.utils.Mathematics
import it.giaquinto.springberry.spring.configuration.Identifier
import it.giaquinto.springberry.spring.configuration.RestRadix
import it.giaquinto.springberry.spring.configuration.SpringBerryConfiguration
import it.giaquinto.springberry.spring.controller.SpringBerryController
import it.giaquinto.springberry.spring.model.api.ApiResult
import it.giaquinto.springberry.spring.model.math.NumberRepresentation
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Simple controller for execute math operation
 */
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
    override fun defaultResponse(): ApiResult<Mathematics> =
        ApiResult.Success(_data = mathematics)

    @GetMapping("${MathController.uniqueRestRadix}/hex/{value}")
    fun toHex(@PathVariable value: String?): ApiResult<String?> =
        try {
            ApiResult.Success(mathematics.toHex(java.lang.Long.decode(value)))
        } catch (numberFormatException: NumberFormatException) {
            ApiResult.Error("Not A Number")
        }

    @GetMapping("${MathController.uniqueRestRadix}/octal/{value}")
    fun toOctal(@PathVariable value: String?): ApiResult<String?> =
        try {
            ApiResult.Success(mathematics.toOctal(java.lang.Long.decode(value)))
        } catch (numberFormatException: NumberFormatException) {
            ApiResult.Error("Not A Number")
        }

    @GetMapping("${MathController.uniqueRestRadix}/binary/{value}")
    fun toBinary(@PathVariable value: String?): ApiResult<String?> =
        try {
            ApiResult.Success(mathematics.toBinary(java.lang.Long.decode(value)))
        } catch (numberFormatException: NumberFormatException) {
            ApiResult.Error("Not A Number")
        }

    @GetMapping("${MathController.uniqueRestRadix}/all/{value}")
    fun toAllBase(@PathVariable value: String?): ApiResult<NumberRepresentation?> =
        try {
            ApiResult.Success(value?.toBigInteger()?.let { mathematics.toAllBase(it) } ?: run { null })
        } catch (_: NumberFormatException) {
            ApiResult.Error("Not a number")
        }

    @GetMapping("${MathController.uniqueRestRadix}/factorial/{value}")
    fun factorial(@PathVariable value: String?): ApiResult<NumberRepresentation?> =
        try {
            ApiResult.Success(value?.toBigInteger()?.let { mathematics.factorial(it) } ?: run { null })
        } catch (_: NumberFormatException) {
            ApiResult.Error("Not a number")
        }

    @GetMapping("${MathController.uniqueRestRadix}/sqrt/{value}")
    fun sqrt(@PathVariable value: String?): ApiResult<NumberRepresentation?> =
        try {
            ApiResult.Success(value?.toBigInteger()?.let { mathematics.sqrt(it) } ?: run { null })
        } catch (_: NumberFormatException) {
            ApiResult.Error("Not a number")
        }

    companion object {
        const val uniqueRestRadix: RestRadix = "math"
    }
}