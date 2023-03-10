package it.giaquinto.springberry.spring.bean.springberrybean.utils

import it.giaquinto.springberry.spring.Identifier
import it.giaquinto.springberry.spring.bean.SpringBerryBean
import it.giaquinto.springberry.spring.model.math.NumberRepresentation
import it.giaquinto.springberry.spring.model.math.number.BigIntegerNumberRepresentation
import java.math.BigInteger

class Mathematics: SpringBerryBean {
    override fun packageIdentifier(): Identifier = this.javaClass.packageName
    fun toHex(decode: Long): String = String.format("%X", decode)

    fun toOctal(decode: Long): String = String.format("%o", decode)

    fun toBinary(decode: Long): String = java.lang.Long.toBinaryString(decode)

    fun toAllBase(decode: BigInteger): NumberRepresentation = BigIntegerNumberRepresentation(decode)

    fun factorial(passed: BigInteger): NumberRepresentation {
        var value = passed
        var returnedValue = BigInteger.valueOf(1)
        while (value.longValueExact() >= 2) {
            returnedValue = returnedValue.times(value)
            value--
        }
        return toAllBase(returnedValue)
    }

    fun sqrt(passed: BigInteger): NumberRepresentation =
        toAllBase(passed.sqrt())


}