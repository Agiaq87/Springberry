package it.giaquinto.springberry.model.raspberry.pin

import it.giaquinto.springberry.model.raspberry.Pin

enum class RaspberryEnumPin(val pin: Int) : Pin {
    SDA1(2), SCL1(5), D4(4), TXD(14), RXD(15), D17(17), PWM18(18), D27(27), D22(22), D23(23), D24(24), MOSI(10), MISO(9), D25(
        25
    ),
    D11(11), CEO(8), CE1(7), D5(5), D6(6), D16(16), D26(26), D20(20), D21(21), PWM12(12), PWM13(13), PWM19(19), NONE(-1);

    companion object {
        fun fromInt(value: Int): RaspberryEnumPin {
            return when (value) {
                2 -> SDA1
                4 -> D4
                14 -> TXD
                15 -> RXD
                17 -> D17
                18 -> PWM18
                27 -> D27
                22 -> D22
                23 -> D23
                24 -> D24
                10 -> MOSI
                9 -> MISO
                25 -> D25
                11 -> D11
                8 -> CEO
                7 -> CE1
                5 -> D5
                6 -> D6
                16 -> D16
                26 -> D26
                20 -> D20
                21 -> D21
                12 -> PWM12
                13 -> PWM13
                19 -> PWM19
                else -> NONE
            }
        }

        fun haveRelativePin(value: Int): Boolean {
            return when (value) {
                2, 9, 4, 14, 15, 17, 18, 27, 22, 23, 24, 10, 25, 11, 8, 7, 5, 6, 13, 16, 26, 20, 21, 12, 19 -> true
                else -> false
            }
        }
    }
}