package it.giaquinto.springberry.spring.model.math.number

import it.giaquinto.springberry.spring.model.math.NumberRepresentation
import java.math.BigInteger
import java.util.*

class BigIntegerNumberRepresentation(defaultBase: BigInteger) : NumberRepresentation {
    override val binary: String = defaultBase.toString(2)
    override val octal: String = defaultBase.toString(8)
    override val hex: String = defaultBase.toString(16)
    override val value: String = defaultBase.toString()
}