package it.giaquinto.springberry.model.raspberry.pin


class OldRaspberryPin(
    /*@param:NonNull val physical: Int,
    @Nullable bcm: Int?,
    @Nullable wiringPi: Int?,
    @param:NonNull val name: String?,
    @param:NonNull var mode: PinMode?,
    @param:NonNull val pinSpecific: PinSpecific?,
    @param:NonNull val volt: PinVolt?,
    @param:NonNull val busPin: BusPin?,
    val isReservedForSpringBerry: Boolean*/
) {
    /*
       // The number printed to the cobbler connector
       val bcm: Int
       val isBcmNamed: Boolean

       // The number used with wiringPi
       val wiringPi: Int
       val isWiringPiNamed: Boolean

       init {
           this.bcm = bcm ?: -1
           isBcmNamed = bcm != null
           this.wiringPi = wiringPi ?: -1
           isWiringPiNamed = wiringPi != null
       }

       override fun equals(o: Any?): Boolean {
           if (this === o) return true
           if (o !is OldRaspberryPin) return false
           if (physical != o.physical) return false
           if (bcm != o.bcm) return false
           if (isBcmNamed != o.isBcmNamed) return false
           if (wiringPi != o.wiringPi) return false
           if (isWiringPiNamed != o.isWiringPiNamed) return false
           if (isReservedForSpringBerry != o.isReservedForSpringBerry) return false
           if (name != o.name) return false
           if (mode !== o.mode) return false
           if (pinSpecific != o.pinSpecific) return false
           return if (volt !== o.volt) false else busPin == o.busPin
       }

       override fun hashCode(): Int {
           var result = physical
           result = 31 * result + bcm
           result = 31 * result + if (isBcmNamed) 1 else 0
           result = 31 * result + wiringPi
           result = 31 * result + if (isWiringPiNamed) 1 else 0
           result = 31 * result + (name?.hashCode() ?: 0)
           result = 31 * result + if (mode != null) mode.hashCode() else 0
           result = 31 * result + (pinSpecific?.hashCode() ?: 0)
           result = 31 * result + (volt?.hashCode() ?: 0)
           result = 31 * result + (busPin?.hashCode() ?: 0)
           result = 31 * result + if (isReservedForSpringBerry) 1 else 0
           return result
       }

       override fun toString(): String {
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
                   '}'
       }

       companion object {
           @JvmStatic
           @Throws(IncorrectPhysicalPinSpecifiedException::class)
           fun fromPhysicalPin(pin: Int): OldRaspberryPin {
               return when (pin) {
                   1 -> OldRaspberryPin(
                       1,
                       null,
                       null,
                       "3.3V",
                       PinMode.OUT,
                       PinSpecific.POWER,
                       PinVolt.STANDARD,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   2 -> OldRaspberryPin(
                       2,
                       null,
                       null,
                       "5.0 VDC",
                       PinMode.OUT,
                       PinSpecific.POWER,
                       PinVolt.SPECIAL,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   3 -> OldRaspberryPin(
                       3,
                       2,
                       8,
                       "GPIO 2",
                       PinMode.OUT,
                       PinSpecific.DIGITAL_WITHOUT_PULLDOWN,
                       PinVolt.STANDARD,
                       BusPin.I2C_INTER_INTEGRATED_CIRCUIT,
                       false
                   )

                   4 -> OldRaspberryPin(
                       4,
                       null,
                       null,
                       "5.0 VDC",
                       PinMode.OUT,
                       PinSpecific.POWER,
                       PinVolt.SPECIAL,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   5 -> OldRaspberryPin(
                       5,
                       3,
                       9,
                       "GPIO 3",
                       PinMode.OUT,
                       PinSpecific.DIGITAL_WITHOUT_PULLDOWN,
                       PinVolt.STANDARD,
                       BusPin.I2C_INTER_INTEGRATED_CIRCUIT,
                       false
                   )

                   6 -> OldRaspberryPin(
                       6,
                       null,
                       null,
                       "GND",
                       PinMode.GROUND,
                       PinSpecific.GROUND,
                       PinVolt.GROUND,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   7 -> OldRaspberryPin(
                       7,
                       4,
                       7,
                       "GPIO 4",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.GPCLK,
                       false
                   )

                   8 -> OldRaspberryPin(
                       8,
                       14,
                       15,
                       "GPIO 14",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.UART_UNIVERSAL_ASYNCHRONOUS_RECEIVER_TRANSMITTER,
                       false
                   )

                   9 -> OldRaspberryPin(
                       9,
                       null,
                       null,
                       "GND",
                       PinMode.GROUND,
                       PinSpecific.GROUND,
                       PinVolt.GROUND,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   10 -> OldRaspberryPin(
                       10,
                       15,
                       16,
                       "GPIO 15",
                       PinMode.IN,
                       PinSpecific.DIGITAL,
                       PinVolt.GROUND,
                       BusPin.UART_UNIVERSAL_ASYNCHRONOUS_RECEIVER_TRANSMITTER,
                       false
                   )

                   11 -> OldRaspberryPin(
                       11,
                       17,
                       0,
                       "GPIO 17",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   12 -> OldRaspberryPin(
                       12,
                       18,
                       1,
                       "GPIO 18",
                       PinMode.OUT,
                       PinSpecific.DIGITAL_AND_PWM,
                       PinVolt.STANDARD,
                       BusPin.PWM,
                       false
                   )

                   13 -> OldRaspberryPin(
                       13,
                       27,
                       2,
                       "GPIO 27",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   14 -> OldRaspberryPin(
                       14,
                       null,
                       null,
                       "GND",
                       PinMode.GROUND,
                       PinSpecific.GROUND,
                       PinVolt.GROUND,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   15 -> OldRaspberryPin(
                       15,
                       22,
                       3,
                       "GPIO 22",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   16 -> OldRaspberryPin(
                       16,
                       23,
                       4,
                       "GPIO 23",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   17 -> OldRaspberryPin(
                       17,
                       null,
                       null,
                       "3.3 VDC",
                       PinMode.OUT,
                       PinSpecific.POWER,
                       PinVolt.STANDARD,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   18 -> OldRaspberryPin(
                       18,
                       24,
                       5,
                       "GPIO 24",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   19 -> OldRaspberryPin(
                       19,
                       10,
                       12,
                       "GPIO 10",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE,
                       false
                   )

                   20 -> OldRaspberryPin(
                       20,
                       null,
                       null,
                       "GND",
                       PinMode.GROUND,
                       PinSpecific.GROUND,
                       PinVolt.GROUND,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   21 -> OldRaspberryPin(
                       21,
                       9,
                       13,
                       "GPIO 9",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE,
                       false
                   )

                   22 -> OldRaspberryPin(
                       22,
                       25,
                       6,
                       "GPIO 25",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   23 -> OldRaspberryPin(
                       23,
                       11,
                       14,
                       "GPIO 11",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE,
                       false
                   )

                   24 -> OldRaspberryPin(
                       24,
                       8,
                       10,
                       "GPIO 8",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE,
                       false
                   )

                   25 -> OldRaspberryPin(
                       25,
                       null,
                       null,
                       "GND",
                       PinMode.GROUND,
                       PinSpecific.GROUND,
                       PinVolt.GROUND,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   26 -> OldRaspberryPin(
                       26,
                       7,
                       11,
                       "GPIO 7",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE,
                       false
                   )

                   27 -> OldRaspberryPin(
                       27,
                       0,
                       30,
                       "GPIO 0",
                       PinMode.OUT,
                       PinSpecific.DIGITAL_WITHOUT_PULLDOWN,
                       PinVolt.STANDARD,
                       BusPin.I2C_INTER_INTEGRATED_CIRCUIT,
                       false
                   )

                   28 -> OldRaspberryPin(
                       28,
                       1,
                       31,
                       "GPIO 1",
                       PinMode.OUT,
                       PinSpecific.DIGITAL_WITHOUT_PULLDOWN,
                       PinVolt.STANDARD,
                       BusPin.I2C_INTER_INTEGRATED_CIRCUIT,
                       false
                   )

                   29 -> OldRaspberryPin(
                       29,
                       5,
                       21,
                       "GPIO 5",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   30 -> OldRaspberryPin(
                       30,
                       null,
                       null,
                       "GND",
                       PinMode.GROUND,
                       PinSpecific.GROUND,
                       PinVolt.GROUND,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   31 -> OldRaspberryPin(
                       31,
                       6,
                       22,
                       "GPIO 6",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   32 -> OldRaspberryPin(
                       32,
                       12,
                       26,
                       "GPIO 5",
                       PinMode.OUT,
                       PinSpecific.DIGITAL_AND_PWM,
                       PinVolt.STANDARD,
                       BusPin.PWM,
                       false
                   )

                   33 -> OldRaspberryPin(
                       33,
                       13,
                       23,
                       "GPIO 13",
                       PinMode.OUT,
                       PinSpecific.DIGITAL_AND_PWM,
                       PinVolt.STANDARD,
                       BusPin.PWM,
                       false
                   )

                   34 -> OldRaspberryPin(
                       34,
                       null,
                       null,
                       "GND",
                       PinMode.GROUND,
                       PinSpecific.GROUND,
                       PinVolt.GROUND,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   35 -> OldRaspberryPin(
                       35,
                       19,
                       24,
                       "GPIO 13",
                       PinMode.OUT,
                       PinSpecific.DIGITAL_AND_PWM,
                       PinVolt.STANDARD,
                       BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE,
                       false
                   )

                   36 -> OldRaspberryPin(
                       36,
                       16,
                       27,
                       "GPIO 16",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   37 -> OldRaspberryPin(
                       37,
                       26,
                       25,
                       "GPIO 26",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   38 -> OldRaspberryPin(
                       38,
                       20,
                       24,
                       "GPIO 20",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE,
                       false
                   )

                   39 -> OldRaspberryPin(
                       39,
                       null,
                       null,
                       "GND",
                       PinMode.GROUND,
                       PinSpecific.GROUND,
                       PinVolt.GROUND,
                       BusPin.NO_PROTOCOL,
                       false
                   )

                   40 -> OldRaspberryPin(
                       40,
                       21,
                       29,
                       "GPIO 21",
                       PinMode.OUT,
                       PinSpecific.DIGITAL,
                       PinVolt.STANDARD,
                       BusPin.SPI_SERIAL_PERIPHERAL_INTERFACE,
                       false
                   )

                   else -> throw IncorrectPhysicalPinSpecifiedException("Unexpected value: $pin")
               }
           }
       }
   */
}
