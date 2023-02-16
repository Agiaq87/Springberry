package it.giaquinto.springberry.model.time

enum class OrderMagnitudeTime {
    FEMTO, PICO, NANO, MICRO, MILLI, SECOND, KILO, MEGA, GIGA, TERA, PETA, EXA, ZETTA;

    companion object {
        @JvmStatic
        fun toNext(value: OrderMagnitudeTime?): OrderMagnitudeTime? {
            return when (value) {
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
                ZETTA -> null
                else -> null
            }
        }
    }
}