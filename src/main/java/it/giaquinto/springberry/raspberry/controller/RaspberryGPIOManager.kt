package it.giaquinto.springberry.raspberry.controller

import com.pi4j.Pi4J
import com.pi4j.context.Context
import com.pi4j.library.pigpio.PiGpio
import com.pi4j.plugin.linuxfs.provider.i2c.LinuxFsI2CProvider
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalInputProvider
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalOutputProvider
import com.pi4j.plugin.pigpio.provider.pwm.PiGpioPwmProvider
import com.pi4j.plugin.pigpio.provider.serial.PiGpioSerialProvider
import com.pi4j.plugin.pigpio.provider.spi.PiGpioSpiProvider
import com.pi4j.plugin.raspberrypi.platform.RaspberryPiPlatform
import it.giaquinto.springberry.raspberry.model.pin.RaspBerryPin
import it.giaquinto.springberry.raspberry.model.pin.modulation.ModulationTechnique
import it.giaquinto.springberry.raspberry.model.pin.specification.PinMode
import it.giaquinto.springberry.raspberry.model.pin.specification.PinVolt


class RaspberryGPIOManager {

    private val piGpio by lazy {
        PiGpio.newNativeInstance()
    }

    private val pi4jContext: Context by lazy {
        Pi4J
            .newContextBuilder()
            .noAutoDetect()
            .add(RaspberryPiPlatform())
            .add(
                PiGpioDigitalInputProvider.newInstance(piGpio),
                PiGpioDigitalOutputProvider.newInstance(piGpio),
                PiGpioPwmProvider.newInstance(piGpio),
                PiGpioSerialProvider.newInstance(piGpio),
                PiGpioSpiProvider.newInstance(piGpio),
                LinuxFsI2CProvider.newInstance()
            )
            .build()
    }

    // TODO delete and use specific map
    private val pinMap: Map<Int, RaspBerryPin> by lazy {
        mapOf(
            Pair(1, RaspBerryPin(1, null, null, "3.3V", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(2, RaspBerryPin(2, null, null, "5.0VDC", PinMode.OUT, PinVolt.SPECIAL, ModulationTechnique.Generic)),
            Pair(3, RaspBerryPin(3, 2, 8, "GPIO 2", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(4, RaspBerryPin(4, null, null, "5.0 VDC", PinMode.OUT, PinVolt.SPECIAL, ModulationTechnique.Generic)),
            Pair(5, RaspBerryPin(5, 3, 9, "GPIO 3", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(6, RaspBerryPin(6, null, null, "GND", PinMode.GROUND, PinVolt.GROUND, ModulationTechnique.Generic)),
            Pair(7, RaspBerryPin(7, 4, 7, "GPIO 4", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(8, RaspBerryPin(8, 14, 15, "GPIO 14", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(9, RaspBerryPin(9, null, null, "GND", PinMode.GROUND, PinVolt.GROUND, ModulationTechnique.Generic)),
            Pair(10, RaspBerryPin(10, 15, 16, "GPIO 15", PinMode.OUT, PinVolt.GROUND, ModulationTechnique.Generic)),
            Pair(11, RaspBerryPin(11, 17, 0, "GPIO 17", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(12, RaspBerryPin(12, 18, 1, "GPIO 18", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(13, RaspBerryPin(13, 27, 2, "GPIO 27", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(14, RaspBerryPin(14, null, null, "GND", PinMode.GROUND, PinVolt.GROUND, ModulationTechnique.Generic)),
            Pair(15, RaspBerryPin(15, 22, 3, "GPIO 22", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(16, RaspBerryPin(16, 23, 4, "GPIO 23", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(
                17,
                RaspBerryPin(17, null, null, "3.3 VDC", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)
            ),
            Pair(18, RaspBerryPin(18, 24, 5, "GPIO 24", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(19, RaspBerryPin(19, 10, 12, "GPIO 10", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(20, RaspBerryPin(20, null, null, "GND", PinMode.GROUND, PinVolt.GROUND, ModulationTechnique.Generic)),
            Pair(21, RaspBerryPin(21, 9, 13, "GPIO 9", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(22, RaspBerryPin(22, 25, 6, "GPIO 25", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(23, RaspBerryPin(23, 11, 14, "GPIO 11", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(24, RaspBerryPin(24, 8, 10, "GPIO 8", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(25, RaspBerryPin(25, null, null, "GND", PinMode.GROUND, PinVolt.GROUND, ModulationTechnique.Generic)),
            Pair(26, RaspBerryPin(26, 7, 11, "GPIO 7", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(27, RaspBerryPin(27, 0, 30, "GPIO 0", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(28, RaspBerryPin(28, 1, 31, "GPIO 1", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(29, RaspBerryPin(29, 5, 21, "GPIO 5", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(30, RaspBerryPin(30, null, null, "GND", PinMode.GROUND, PinVolt.GROUND, ModulationTechnique.Generic)),
            Pair(31, RaspBerryPin(31, 6, 22, "GPIO 6", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(32, RaspBerryPin(32, 12, 26, "GPIO 5", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(33, RaspBerryPin(33, 13, 23, "GPIO 13", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(34, RaspBerryPin(34, null, null, "GND", PinMode.GROUND, PinVolt.GROUND, ModulationTechnique.Generic)),
            Pair(35, RaspBerryPin(35, 19, 24, "GPIO 13", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(36, RaspBerryPin(36, 16, 27, "GPIO 16", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(37, RaspBerryPin(37, 26, 25, "GPIO 26", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(38, RaspBerryPin(38, 20, 24, "GPIO 20", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
            Pair(39, RaspBerryPin(39, null, null, "GND", PinMode.GROUND, PinVolt.GROUND, ModulationTechnique.Generic)),
            Pair(40, RaspBerryPin(40, 21, 29, "GPIO 21", PinMode.OUT, PinVolt.STANDARD, ModulationTechnique.Generic)),
        )
    }

    val visualInformer: RaspberryVisualInformer by lazy {
        RaspberryVisualInformer(
            pi4jContext,
            pinMap[12]!!,
            pinMap[16]!!,
            pinMap[18]!!
        )
    }

    /*    val i2c0: I2CProtocol = TODO()
        val i2c1: I2CProtocol = TODO()
        val spi0: SPIProtocol = TODO()
        val spi1: SPIProtocol = TODO()
        val uart0: UARTProtocol = TODO()
        val uart1: UARTProtocol = TODO()*/

    init {

        /*i2c0 = I2CProtocol(data = pinMap[3]!!, clock = pinMap[5]!!)
        i2c1 = I2CProtocol(data = pinMap[27]!!, clock = pinMap[28]!!)*/
    }

}