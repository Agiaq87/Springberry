package it.giaquinto.springberry.model.raspberry.pin

enum class VoltPin(v: Double) {
    GROUND(0.0), STANDARD(3.3), SPECIAL(5.0)
}