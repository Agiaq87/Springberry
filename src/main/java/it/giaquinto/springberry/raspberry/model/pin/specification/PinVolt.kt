package it.giaquinto.springberry.raspberry.model.pin.specification

enum class PinVolt(volt: Double) {
    GROUND(0.0), STANDARD(3.3), SPECIAL(5.0)
}