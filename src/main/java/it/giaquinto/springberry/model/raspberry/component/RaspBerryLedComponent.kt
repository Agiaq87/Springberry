package it.giaquinto.springberry.model.raspberry.component

import com.pi4j.context.Context
import com.pi4j.io.gpio.digital.DigitalOutput
import com.pi4j.io.gpio.digital.DigitalOutputConfig
import it.giaquinto.springberry.model.raspberry.RaspBerryComponent
import it.giaquinto.springberry.model.raspberry.pin.RaspberryEnumPin

class RaspBerryLedComponent(pi4j: Context, val address: RaspberryEnumPin) : RaspBerryComponent() {
    /**
     * Returns the instance of the digital output
     *
     * @return DigitalOutput instance of the LED
     */
    /**
     * Pi4J digital output instance used by this component
     */
    val digitalOutput: DigitalOutput

    /**
     * Creates a new simpleLed component with a custom BCM pin.
     *
     * @param pi4j    Pi4J context
     * @param address Custom BCM pin address
     */
    init {
        digitalOutput = pi4j.create(buildDigitalOutputConfig(pi4j, address))
    }

    /**
     * Set the LED on or off depending on the boolean argument.
     *
     * @param on Sets the LED to on (true) or off (false)
     */
    fun setState(on: Boolean) {
        digitalOutput.setState(on)
    }

    /**
     * Sets the LED to on.
     */
    fun on() {
        digitalOutput.on()
    }

    /**
     * Sets the LED to off
     */
    fun off() {
        digitalOutput.off()
    }

    /**
     * Toggle the LED state depending on its current state.
     *
     * @return Return true or false according to the new state of the relay.
     */
    fun toggleState(): Boolean {
        digitalOutput.toggle()
        return digitalOutput.isOff
    }

    /**
     * Configure Digital Output
     *
     * @param pi4j    PI4J Context
     * @param address GPIO Address of the relay
     * @return Return Digital Output configuration
     */
    protected fun buildDigitalOutputConfig(pi4j: Context?, address: RaspberryEnumPin): DigitalOutputConfig {
        return DigitalOutput.newConfigBuilder(pi4j)
            .id("BCM$address")
            .name("LED")
            .address(address.pin)
            .build()
    }
}