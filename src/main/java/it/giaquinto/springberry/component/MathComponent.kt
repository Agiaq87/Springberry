package it.giaquinto.springberry.component

import it.giaquinto.springberry.model.math.NumberRepresentation
import it.giaquinto.springberry.model.math.number.BigIntegerNumberRepresentation
import it.giaquinto.springberry.model.math.number.LongNumberRepresentation
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.math.BigInteger

@Component
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class MathComponent {
    fun factorial(passed: Long): Long {
        var value = passed
        var returnedValue = 1L
        while (value >= 2) {
            returnedValue *= value
            value--
        }
        return returnedValue
    }

    fun toHex(decode: Long?): String {
        return String.format("%X", decode)
    }

    fun toOctal(decode: Long?): String {
        return String.format("%o", decode)
    }

    fun toBinary(decode: Long?): String {
        return java.lang.Long.toBinaryString(decode!!)
    }

    fun toAllBase(decode: Long?): NumberRepresentation {
        return LongNumberRepresentation(decode!!)
    }

    fun toAllBase(decode: Int?): NumberRepresentation =
        decode?.let {
            BigIntegerNumberRepresentation(it.toLong())
        } ?: run {
            BigIntegerNumberRepresentation(0L)
        }
}