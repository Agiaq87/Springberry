package it.giaquinto.springberry.raspberry

import com.pi4j.context.Context
import com.pi4j.io.gpio.digital.DigitalInput
import com.pi4j.io.gpio.digital.DigitalOutput
import com.pi4j.io.gpio.digital.DigitalState
import it.giaquinto.springberry.raspberry.model.pin.RaspBerryPin

typealias ProtocolName = String
typealias PinAddress = Int
typealias BcmAddress = Int
typealias WiringPiAddress = Int
typealias PinName = String

fun Context.makeDigitalOutput(pin: RaspBerryPin): DigitalOutput =
    create(
        DigitalOutput
            .newConfigBuilder(this)
            .id("${pin.physical}")
            .name(pin.name)
            .address(pin.bcmAddress)
            .initial(DigitalState.LOW)
            .build()
    )

fun Context.makeInput(pin: RaspBerryPin): DigitalInput =
    create(
        DigitalInput
            .newConfigBuilder(this)
            .id("${pin.physical}")
            .name(pin.name)
            .address(pin.bcmAddress)
            .build()
    )

fun loop(action: () -> Unit) {
    while (true) {
        action()
    }
}