package it.giaquinto.springberry.model.raspberry.pin;

public enum VoltPin {
    GROUND(0),
    STANDARD(3.3),
    SPECIAL(5.0);

    VoltPin(double v) {

    }
}
