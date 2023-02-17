package it.giaquinto.springberry.model.time

enum class OrderMagnitudeTime {
    FEMTO, PICO, NANO, MICRO, MILLI, SECOND, KILO, MEGA, GIGA, TERA, PETA, EXA, ZETTA , UNDEFINED;

    companion object {
        fun toNext(value: OrderMagnitudeTime): OrderMagnitudeTime =
            when (value) {
                FEMTO -> PICO
                PICO -> NANO
                NANO -> MICRO
                MICRO -> MILLI
                MILLI -> SECOND
                SECOND -> KILO
                KILO -> MEGA
                MEGA -> GIGA
                GIGA -> TERA
                TERA -> TERA
                PETA -> PETA
                EXA -> ZETTA
                ZETTA -> UNDEFINED
                else -> UNDEFINED
            }

        fun hasNext(value: OrderMagnitudeTime): Boolean =
            when(value) {
                ZETTA -> false
                else -> true
            }
    }
}