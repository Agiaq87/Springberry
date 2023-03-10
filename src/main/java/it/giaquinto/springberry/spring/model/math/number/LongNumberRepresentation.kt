package it.giaquinto.springberry.spring.model.math.number

import it.giaquinto.springberry.spring.model.math.NumberRepresentation

class LongNumberRepresentation(defaultBase: Long) : NumberRepresentation {
    override val binary: String = java.lang.Long.toBinaryString(defaultBase)
    override val octal: String = String.format("%o", defaultBase)
    override val hex: String = String.format("%X", defaultBase)
    override val value: String = defaultBase.toString()
}