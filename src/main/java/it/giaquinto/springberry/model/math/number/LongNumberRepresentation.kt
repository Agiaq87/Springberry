package it.giaquinto.springberry.model.math.number

import it.giaquinto.springberry.model.math.NumberRepresentation
import java.util.*

class LongNumberRepresentation(private val defaultBase: Long) : NumberRepresentation() {
    override val binary: String
    override val octal: String
    override val hex: String

    init {
        val decode = defaultBase
        binary = java.lang.Long.toBinaryString(defaultBase)
        octal = String.format("%o", decode)
        hex = String.format("%X", decode)
    }

    override val value: String?
        get() = java.lang.Long.toString(defaultBase)

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        return if (o !is LongNumberRepresentation) false else defaultBase == o.defaultBase && binary == o.binary && octal == o.octal && hex == o.hex
    }

    override fun hashCode(): Int {
        return Objects.hash(defaultBase, binary, octal, hex)
    }

    override fun toString(): String {
        return "NumberRepresentation{" +
                "value=" + defaultBase +
                ", binary='" + binary + '\'' +
                ", octal='" + octal + '\'' +
                ", hex='" + hex + '\'' +
                '}'
    }
}