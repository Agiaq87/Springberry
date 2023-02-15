package it.giaquinto.springberry.model.raspberry.pin;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

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

    private final boolean isReservedForSpringBerry;

    public RaspberryPin(
            @NonNull final int physical,
            @Nullable final Integer bcm,
            @Nullable final Integer wiringPi,
            @NonNull final String name,
            @NonNull final PinMode mode,
            @NonNull final PinSpecific pinSpecific,
            @NonNull final VoltPin volt,
            @NonNull final BusPin busPin,
            final boolean isReservedForSpringBerry
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
        this.isReservedForSpringBerry = isReservedForSpringBerry;
    }

    public int getPhysical() {
        return physical;
    }

    public int getBcm() {
        return bcm;
    }

    public boolean isBcmNamed() {
        return isBcmNamed;
    }

    public int getWiringPi() {
        return wiringPi;
    }

    public boolean isWiringPiNamed() {
        return isWiringPiNamed;
    }

    public String getName() {
        return name;
    }

    public PinMode getMode() {
        return mode;
    }

    public void setMode(PinMode mode) {
        this.mode = mode;
    }

    public PinSpecific getPinSpecific() {
        return pinSpecific;
    }

    public VoltPin getVolt() {
        return volt;
    }

    public BusPin getBusPin() {
        return busPin;
    }

    public boolean isReservedForSpringBerry() {
        return isReservedForSpringBerry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RaspberryPin that)) return false;

        if (physical != that.physical) return false;
        if (bcm != that.bcm) return false;
        if (isBcmNamed != that.isBcmNamed) return false;
        if (wiringPi != that.wiringPi) return false;
        if (isWiringPiNamed != that.isWiringPiNamed) return false;
        if (isReservedForSpringBerry != that.isReservedForSpringBerry) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (mode != that.mode) return false;
        if (pinSpecific != that.pinSpecific) return false;
        if (volt != that.volt) return false;
        return busPin == that.busPin;
    }

    @Override
    public int hashCode() {
        int result = physical;
        result = 31 * result + bcm;
        result = 31 * result + (isBcmNamed ? 1 : 0);
        result = 31 * result + wiringPi;
        result = 31 * result + (isWiringPiNamed ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mode != null ? mode.hashCode() : 0);
        result = 31 * result + (pinSpecific != null ? pinSpecific.hashCode() : 0);
        result = 31 * result + (volt != null ? volt.hashCode() : 0);
        result = 31 * result + (busPin != null ? busPin.hashCode() : 0);
        result = 31 * result + (isReservedForSpringBerry ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RaspberryPin{" +
                "physical=" + physical +
                ", bcm=" + bcm +
                ", isBcmNamed=" + isBcmNamed +
                ", wiringPi=" + wiringPi +
                ", isWiringPiNamed=" + isWiringPiNamed +
                ", name='" + name + '\'' +
                ", mode=" + mode +
                ", pinSpecific=" + pinSpecific +
                ", volt=" + volt +
                ", busPin=" + busPin +
                ", isReservedForSpringBerry=" + isReservedForSpringBerry +
                '}';
    }

    public static RaspberryPin fromPhysicalPin(final int pin) throws IncorrectPhysicalPinSpecifiedException {
        return switch(pin) {
            case 1 -> new RaspberryPin(1, null, null, "3.3V", PinMode.OUT, PinSpecific.POWER, VoltPin.STANDARD, BusPin.NO_PROTOCOL, false);
            case 2 -> new RaspberryPin(2, null, null, "5.0 VDC", PinMode.OUT, PinSpecific.POWER, VoltPin.SPECIAL, BusPin.NO_PROTOCOL, false);
            case 3 -> new RaspberryPin(3, 2, 8, "GPIO 2", PinMode.OUT, PinSpecific.DIGITAL_WITHOUT_PULLDOWN, VoltPin.STANDARD, BusPin.I2C_INTER_INTEGRATED_CIRCUIT, false);
            case 4 -> new RaspberryPin(4, null, null, "5.0 VDC", PinMode.OUT, PinSpecific.POWER, VoltPin.SPECIAL, BusPin.NO_PROTOCOL, false);
            case 5 -> new RaspberryPin(5,3,9,"GPIO 3", PinMode.OUT, PinSpecific.DIGITAL_WITHOUT_PULLDOWN, VoltPin.STANDARD, BusPin.I2C_INTER_INTEGRATED_CIRCUIT, false);
            case 6 -> new RaspberryPin(6, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL, false);
            case 7 -> new RaspberryPin(7, 4, 7, "GPIO 4", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.GPCLK, false);
            case 8 -> new RaspberryPin(8, 14, 15, "GPIO 14", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.UART_UNIVERSAL_ASYNCHRONOUS_RECEIVER_TRANSMITTER, false);
            case 9 -> new RaspberryPin(9, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL, false);
            case 10 -> new RaspberryPin(10, 15, 16, "GPIO 15", PinMode.IN, PinSpecific.DIGITAL, VoltPin.GROUND, BusPin.UART_UNIVERSAL_ASYNCHRONOUS_RECEIVER_TRANSMITTER, false);
            case 11 -> new RaspberryPin(11, 17, 0, "GPIO 17", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL, false);
            case 12 -> new RaspberryPin(12, 18, 1, "GPIO 18", PinMode.OUT, PinSpecific.DIGITAL_AND_PWM, VoltPin.STANDARD, BusPin.PWM, false);
            case 13 -> new RaspberryPin(13, 27, 2, "GPIO 27", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL, false);
            case 14 -> new RaspberryPin(14, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL, false);
            case 15 -> new RaspberryPin(15, 22, 3, "GPIO 22", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL, false);
            case 16 -> new RaspberryPin(16, 23, 4, "GPIO 23", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL, false);
            case 17 -> new RaspberryPin(17, null, null, "3.3 VDC", PinMode.OUT, PinSpecific.POWER, VoltPin.STANDARD, BusPin.NO_PROTOCOL, false);
            case 18 -> new RaspberryPin(18, 24, 5, "GPIO 24", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL, false);
            case 19 -> new RaspberryPin(19, 10, 12, "GPIO 10", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE, false);
            case 20 -> new RaspberryPin(20, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL, false);
            case 21 -> new RaspberryPin(21, 9, 13, "GPIO 9", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE, false);
            case 22 -> new RaspberryPin(22, 25, 6, "GPIO 25", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL, false);
            case 23 -> new RaspberryPin(23, 11, 14, "GPIO 11", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE, false);
            case 24 -> new RaspberryPin(24, 8, 10, "GPIO 8", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE, false);
            case 25 -> new RaspberryPin(25, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL, false);
            case 26 -> new RaspberryPin(26, 7, 11, "GPIO 7", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE, false);
            case 27 -> new RaspberryPin(27, 0, 30, "GPIO 0", PinMode.OUT, PinSpecific.DIGITAL_WITHOUT_PULLDOWN, VoltPin.STANDARD, BusPin.I2C_INTER_INTEGRATED_CIRCUIT, false);
            case 28 -> new RaspberryPin(28, 1, 31, "GPIO 1", PinMode.OUT, PinSpecific.DIGITAL_WITHOUT_PULLDOWN, VoltPin.STANDARD, BusPin.I2C_INTER_INTEGRATED_CIRCUIT, false);
            case 29 -> new RaspberryPin(29, 5, 21, "GPIO 5", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL, false);
            case 30 -> new RaspberryPin(30, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL, false);
            case 31 -> new RaspberryPin(31, 6, 22, "GPIO 6", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL, false);
            case 32 -> new RaspberryPin(32, 12, 26, "GPIO 5", PinMode.OUT, PinSpecific.DIGITAL_AND_PWM, VoltPin.STANDARD, BusPin.PWM, false);
            case 33 -> new RaspberryPin(33, 13, 23, "GPIO 13", PinMode.OUT, PinSpecific.DIGITAL_AND_PWM, VoltPin.STANDARD, BusPin.PWM, false);
            case 34 -> new RaspberryPin(34, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL, false);
            case 35 -> new RaspberryPin(35, 19, 24, "GPIO 13", PinMode.OUT, PinSpecific.DIGITAL_AND_PWM, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE, false);
            case 36 -> new RaspberryPin(36, 16, 27, "GPIO 16", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL, false);
            case 37 -> new RaspberryPin(37, 26, 25, "GPIO 26", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.NO_PROTOCOL, false);
            case 38 -> new RaspberryPin(38, 20, 24, "GPIO 20", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE, false);
            case 39 -> new RaspberryPin(39, null, null, "GND", PinMode.GROUND, PinSpecific.GROUND, VoltPin.GROUND, BusPin.NO_PROTOCOL, false);
            case 40 -> new RaspberryPin(40, 21, 29, "GPIO 21", PinMode.OUT, PinSpecific.DIGITAL, VoltPin.STANDARD, BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE, false);
            default -> throw new IncorrectPhysicalPinSpecifiedException("Unexpected value: " + pin);
        };
    }
}
