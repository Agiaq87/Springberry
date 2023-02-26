package it.giaquinto.springberry.raspberry.controller

import com.pi4j.context.Context
import com.pi4j.io.gpio.digital.DigitalOutput
import it.giaquinto.springberry.raspberry.cancelIfActive
import it.giaquinto.springberry.raspberry.loop
import it.giaquinto.springberry.raspberry.makeDigitalOutput
import it.giaquinto.springberry.raspberry.model.pin.RaspBerryPin
import it.giaquinto.springberry.raspberry.model.pin.configuration.BlinkConfiguration
import kotlinx.coroutines.*

class RaspberryLedExecutorInformer(pi4jContext: Context, green: RaspBerryPin, yellow: RaspBerryPin, red: RaspBerryPin): RaspberryLedInformer {

    override val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    // WARNING
    // Default pin is 16 - BCM 23
    private val yellowLed: DigitalOutput = pi4jContext.makeDigitalOutput(yellow)
    private var yellowJob: Job? = null

    // ERROR
    // Default pin is 18 - BCM 24
    private val redLed: DigitalOutput = pi4jContext.makeDigitalOutput(red)
    private var redJob: Job? = null


    // OK
    // Default pin is 22 - BCM 25
    private val greenLed: DigitalOutput = pi4jContext.makeDigitalOutput(green)
    private var greenJob: Job? = null


    fun onRequest(authorized: Boolean) =
        if (authorized)
            greenJob = blink(greenLed, greenJob, BlinkConfiguration.Request)
        else
            yellowJob = blink(yellowLed, yellowJob, BlinkConfiguration.Request)

    fun onResponse(authorized: Boolean) =
        if (authorized)
            greenJob = blink(greenLed, greenJob, BlinkConfiguration.Response)
        else
            yellowJob = blink(yellowLed, yellowJob, BlinkConfiguration.Response)

    fun onError() {
        redJob = blink(redLed, redJob, BlinkConfiguration.HandlerException)
    }
}