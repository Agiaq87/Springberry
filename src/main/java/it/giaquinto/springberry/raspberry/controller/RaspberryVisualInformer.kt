package it.giaquinto.springberry.raspberry.controller

import com.pi4j.context.Context
import com.pi4j.io.gpio.digital.DigitalOutput
import com.pi4j.io.gpio.digital.DigitalOutputConfig
import it.giaquinto.springberry.raspberry.model.pin.RaspBerryPin

class RaspberryVisualInformer(pi4jContext: Context, red: RaspBerryPin, green: RaspBerryPin, blue: RaspBerryPin) {
    private val redLed: DigitalOutputConfig =
        DigitalOutput
            .newConfigBuilder(pi4jContext)
            .id("BCM ${red.physical}")
            .name("Red Led")
            .address(red.physical)
            .build()

    private val greenLed: DigitalOutputConfig =
        DigitalOutput
            .newConfigBuilder(pi4jContext)
            .id("BCM ${green.physical}")
            .name("Green Led")
            .address(green.physical)
            .build()

    private val blueLed: DigitalOutputConfig =
        DigitalOutput
            .newConfigBuilder(pi4jContext)
            .id("BCM ${blue.physical}")
            .name("Blue Led")
            .address(blue.physical)
            .build()
}