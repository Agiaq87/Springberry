package it.giaquinto.springberry.model.raspberry.pin;

public enum RaspberryEnumPin /*implements Pin*/ {
    SDA1(2),
    SCL1(5),
    D4(4),
    TXD(14),
    RXD(15),
    D17(17),
    PWM18(18),
    D27(27),
    D22(22),
    D23(23),
    D24(24),
    MOSI(10),
    MISO(9),
    D25(25),
    D11(11),
    CEO(8),
    CE1(7),
    D5(5),
    D6(6),
    D16(16),
    D26(26),
    D20(20),
    D21(21),
    PWM12(12),
    PWM13(13),
    PWM19(19);

    private final int pin;

    RaspberryEnumPin(int pin) {
        this.pin = pin;
    }

    public final int getPin() {
        return pin;
    }

    public static RaspberryEnumPin fromInt(final int value) {
        return switch (value) {
            case 2 -> RaspberryEnumPin.SDA1;
            case 4 -> RaspberryEnumPin.D4;
            case 14 -> RaspberryEnumPin.TXD;
            case 15 -> RaspberryEnumPin.RXD;
            case 17 -> RaspberryEnumPin.D17;
            case 18 -> RaspberryEnumPin.PWM18;
            case 27 -> RaspberryEnumPin.D27;
            case 22 -> RaspberryEnumPin.D22;
            case 23 -> RaspberryEnumPin.D23;
            case 24 -> RaspberryEnumPin.D24;
            case 10 -> RaspberryEnumPin.MOSI;
            case 9 -> RaspberryEnumPin.MISO;
            case 25 -> RaspberryEnumPin.D25;
            case 11 -> RaspberryEnumPin.D11;
            case 8 -> RaspberryEnumPin.CEO;
            case 7 -> RaspberryEnumPin.CE1;
            case 5 -> RaspberryEnumPin.D5;
            case 6 -> RaspberryEnumPin.D6;
            case 16 -> RaspberryEnumPin.D16;
            case 26 -> RaspberryEnumPin.D26;
            case 20 -> RaspberryEnumPin.D20;
            case 21 -> RaspberryEnumPin.D21;
            case 12 -> RaspberryEnumPin.PWM12;
            case 13 -> RaspberryEnumPin.PWM13;
            case 19 -> RaspberryEnumPin.PWM19;
            default -> null;
        };
    }

    public static boolean haveRelativePin(final int value) {
        return switch (value) {
            case 2, 9, 4, 14, 15, 17, 18, 27, 22, 23, 24, 10, 25, 11, 8, 7, 5, 6, 13, 16, 26, 20, 21, 12, 19 -> true;
            default -> false;
        };
    }
}
