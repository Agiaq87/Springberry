package it.giaquinto.springberry.model.raspberry;

public enum RaspberryPin {
    SDA1(2),
    SCL1(2),
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

    RaspberryPin(int pin) {
        this.pin = pin;
    }

    public final int getPin() {
        return pin;
    }

    public static RaspberryPin fromInt(final int value) {
        return switch (value) {
            case 2 -> RaspberryPin.SDA1;
            case 4 -> RaspberryPin.D4;
            case 14 -> RaspberryPin.TXD;
            case 15 -> RaspberryPin.RXD;
            case 17 -> RaspberryPin.D17;
            case 18 -> RaspberryPin.PWM18;
            case 27 -> RaspberryPin.D27;
            case 22 -> RaspberryPin.D22;
            case 23 -> RaspberryPin.D23;
            case 24 -> RaspberryPin.D24;
            case 10 -> RaspberryPin.MOSI;
            case 9 -> RaspberryPin.MISO;
            case 25 -> RaspberryPin.D25;
            case 11 -> RaspberryPin.D11;
            case 8 -> RaspberryPin.CEO;
            case 7 -> RaspberryPin.CE1;
            case 5 -> RaspberryPin.D5;
            case 6 -> RaspberryPin.D6;
            case 16 -> RaspberryPin.D16;
            case 26 -> RaspberryPin.D26;
            case 20 -> RaspberryPin.D20;
            case 21 -> RaspberryPin.D21;
            case 12 -> RaspberryPin.PWM12;
            case 13 -> RaspberryPin.PWM13;
            case 19 -> RaspberryPin.PWM19;
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
