package it.giaquinto.springberry.raspberry.controller

import com.pi4j.context.Context
import com.pi4j.io.gpio.digital.DigitalOutput
import it.giaquinto.springberry.raspberry.cancelIfActive
import it.giaquinto.springberry.raspberry.loop
import it.giaquinto.springberry.raspberry.makeDigitalOutput
import it.giaquinto.springberry.raspberry.model.pin.RaspBerryPin
import it.giaquinto.springberry.raspberry.model.pin.configuration.BlinkConfiguration
import kotlinx.coroutines.*

class RaspberryVisualInformer(pi4jContext: Context, green: RaspBerryPin, yellow: RaspBerryPin, red: RaspBerryPin) {

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    // STATUS
    // Default pin is 12 - BCM 18
    private val yellowLed: DigitalOutput = pi4jContext.makeDigitalOutput(yellow)
    private var yellowJob: Job? = null


    // EXECUTION
    // Default pin is 16 - BCM 23
    private val greenLed: DigitalOutput = pi4jContext.makeDigitalOutput(green)
    private var greenJob: Job? = null

    // ERROR
    // Default pin is 18 - BCM 24
    private val redLed: DigitalOutput = pi4jContext.makeDigitalOutput(red)
    private var redJob: Job? = null


    private fun blink(
        led: DigitalOutput,
        job: Job?,
        blinkConfiguration: BlinkConfiguration,
        repeat: Boolean = false
    ): Job {
        job?.cancelIfActive()

        return coroutineScope.launch {
            if (repeat) {
                loop {
                    _blink(led, blinkConfiguration)
                }
            } else {
                _blink(led, blinkConfiguration)
            }
        }
    }

    private fun _blink(led: DigitalOutput, blinkConfiguration: BlinkConfiguration) {
        led.on()
        Thread.sleep(blinkConfiguration.delay)
        led.off()
        Thread.sleep(blinkConfiguration.duration)
    }

    fun onStart() {
        greenJob = blink(greenLed, greenJob, BlinkConfiguration.Normal, true)
    }


    fun onWarning() {
        yellowJob = blink(yellowLed, yellowJob, BlinkConfiguration.Warning)
    }

    fun onError() {
        redJob = blink(redLed, redJob, BlinkConfiguration.Error)
    }

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
}