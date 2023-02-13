package it.giaquinto.springberry.model.raspberry.pin;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class RaspberryPin {
    private final int physical;

    // The number printed to the cobbler connector
    private final int bcm;

    private final boolean isBcmNamed;

    // The number used with wiringPi
    private final int wiringPi;

    private final boolean isWiringPiNamed;
    private final String name;
    private PinMode mode;
    private final PinSpecific pinSpecific;

    private final VoltPin volt;

    private final BusPin busPin;

    public RaspberryPin(
            @NonNull final int physical,
            @Nullable final Integer bcm,
            @Nullable final Integer wiringPi,
            @NonNull final String name,
            @NonNull final PinMode mode,
            @NonNull final PinSpecific pinSpecific,
            @NonNull final VoltPin volt,
            @NonNull final BusPin busPin
    ) {
        this.physical = physical;
        this.bcm = bcm != null ? bcm.intValue() : -1;
        this.isBcmNamed = bcm != null;
        this.wiringPi = wiringPi != null ? wiringPi.intValue() : -1;
        this.isWiringPiNamed = wiringPi != null;
        this.name = name;
        this.mode = mode;
        this.pinSpecific = pinSpecific;
        this.volt = volt;
        this.busPin = busPin;
    }

    public static RaspberryPin fromPhysicalPin(final int pin) throws IncorrectPhysicalPinSpecifiedException {
        return switch(pin) {
            case 1 -> new RaspberryPin(1, null, null, "3.3V", PinMode.OUT, PinSpecific.POWER, VoltPin.STANDARD, BusPin.NO_PROTOCOL);
            case 2 -> new RaspberryPin(2, null, null, "5.0 VDC", PinMode.OUT, PinSpecific.POWER, VoltPin.SPECIAL, BusPin.NO_PROTOCOL);
            case 3 -> new RaspberryPin(3, 2, 8, "GPIO 2", PinMode.OUT, PinSpecific.DIGITAL_WITHOUT_PULLDOWN, VoltPin.STANDARD, BusPin.I2C_INTER_INTEGRATED_CIRCUIT);
            case 4 -> new RaspberryPin(4, null, null, "5.0 VDC", PinMode.OUT, PinSpecific.POWER, VoltPin.SPECIAL, BusPin.NO_PROTOCOL);
            case 5 -> new RaspberryPin(5,3,9,"GPIO 3", PinMode.OUT, PinSpecific.DIGITAL_WITHOUT_PULLDOWN, VoltPin.STANDARD, BusPin.I2C_INTER_INTEGRATED_CIRCUIT);
            case 6 -> new RaspberryPin(6, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL);
            case 7 -> new RaspberryPin(7, 4, 7, "GPIO 4", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.GPCLK);
            case 8 -> new RaspberryPin(8, 14, 15, "GPIO 14", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.UART_UNIVERSAL_ASYNCHRONOUS_RECEIVER_TRANSMITTER);
            case 9 -> new RaspberryPin(9, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL);
            case 10 -> new RaspberryPin(10, 15, 16, "GPIO 15", PinMode.IN, PinSpecific.DIGITAL, VoltPin.GROUND, BusPin.UART_UNIVERSAL_ASYNCHRONOUS_RECEIVER_TRANSMITTER);
            case 11 -> new RaspberryPin(11, 17, 0, "GPIO 17", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL);
            case 12 -> new RaspberryPin(12, 18, 1, "GPIO 18", PinMode.OUT, PinSpecific.DIGITAL_AND_PWM, VoltPin.STANDARD, BusPin.PWM);
            case 13 -> new RaspberryPin(13, 27, 2, "GPIO 27", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL);
            case 14 -> new RaspberryPin(14, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL);
            case 15 -> new RaspberryPin(15, 22, 3, "GPIO 22", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL);
            case 16 -> new RaspberryPin(16, 23, 4, "GPIO 23", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL);
            case 17 -> new RaspberryPin(17, null, null, "3.3 VDC", PinMode.OUT, PinSpecific.POWER, VoltPin.STANDARD, BusPin.NO_PROTOCOL);
            case 18 -> new RaspberryPin(18, 24, 5, "GPIO 24", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL);
            case 19 -> new RaspberryPin(19, 10, 12, "GPIO 10", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE);
            case 20 -> new RaspberryPin(20, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL);
            case 21 -> new RaspberryPin(21, 9, 13, "GPIO 9", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE);
            case 22 -> new RaspberryPin(22, 25, 6, "GPIO 25", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL);
            case 23 -> new RaspberryPin(23, 11, 14, "GPIO 11", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE);
            case 24 -> new RaspberryPin(24, 8, 10, "GPIO 8", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE);
            case 25 -> new RaspberryPin(25, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL);
            case 26 -> new RaspberryPin(26, 7, 11, "GPIO 7", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE);
            case 27 -> new RaspberryPin(27, 0, 30, "GPIO 0", PinMode.OUT, PinSpecific.DIGITAL_WITHOUT_PULLDOWN, VoltPin.STANDARD, BusPin.I2C_INTER_INTEGRATED_CIRCUIT);
            case 28 -> new RaspberryPin(28, 1, 31, "GPIO 1", PinMode.OUT, PinSpecific.DIGITAL_WITHOUT_PULLDOWN, VoltPin.STANDARD, BusPin.I2C_INTER_INTEGRATED_CIRCUIT);
            case 29 -> new RaspberryPin(29, 5, 21, "GPIO 5", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL);
            case 30 -> new RaspberryPin(30, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL);
            case 31 -> new RaspberryPin(31, 6, 22, "GPIO 6", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL);
            case 32 -> new RaspberryPin(32, 12, 26, "GPIO 5", PinMode.OUT, PinSpecific.DIGITAL_AND_PWM, VoltPin.STANDARD, BusPin.PWM);
            case 33 -> new RaspberryPin(33, 13, 23, "GPIO 13", PinMode.OUT, PinSpecific.DIGITAL_AND_PWM, VoltPin.STANDARD, BusPin.PWM);
            case 34 -> new RaspberryPin(34, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL);
            case 35 -> new RaspberryPin(35, 19, 24, "GPIO 13", PinMode.OUT, PinSpecific.DIGITAL_AND_PWM, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE);
            case 36 -> new RaspberryPin(36, 16, 27, "GPIO 16", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL);
            case 37 -> new RaspberryPin(37, 26, 25, "GPIO 26", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL);
            case 38 -> new RaspberryPin(38, 20, 24, "GPIO 20", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE);
            case 39 -> new RaspberryPin(39, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL);
            case 40 -> new RaspberryPin(40, 21, 29, "GPIO 21", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE);
            default -> throw new IncorrectPhysicalPinSpecifiedException("Unexpected value: " + pin);
        };
    }
}
