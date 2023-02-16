package it.giaquinto.springberry.model.raspberry.pin

enum class LCDPin(i: Int) {
    GROUND(1), VCC(2), CONTRAST(3), REGISTER_SELECT(4), READ_WRITE(5), CLOCK(6), BIT0(7), BIT1(8), BIT2(9), BIT3(10), BIT4(
        11
    ),
    BIT5(12), BIT6(13), BIT7(14), BACKLIGHT_LED_ANODE(15), BACKLIGHT_LED_CATHODE(16)
}