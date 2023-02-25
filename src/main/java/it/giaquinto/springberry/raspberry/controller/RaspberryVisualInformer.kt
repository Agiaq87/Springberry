package it.giaquinto.springberry.raspberry.controller

import com.pi4j.context.Context
import com.pi4j.io.gpio.digital.DigitalOutput
import it.giaquinto.springberry.raspberry.loop
import it.giaquinto.springberry.raspberry.makeDigitalOutput
import it.giaquinto.springberry.raspberry.model.pin.RaspBerryPin
import it.giaquinto.springberry.raspberry.model.pin.configuration.BlinkConfiguration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

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

    fun test() {
        greenJob = systemBlink(greenLed, greenJob, BlinkConfiguration.Normal)
        yellowJob = systemBlink(yellowLed, yellowJob, BlinkConfiguration.Warning)
        redJob = systemBlink(redLed, redJob, BlinkConfiguration.Error)
    }

    private fun systemBlink(
        led: DigitalOutput,
        job: Job?,
        blinkConfiguration: BlinkConfiguration
    ): Job {
        if (job?.isActive == true)
            job.cancel()

        return coroutineScope.launch {
            loop {
                led.blink(blinkConfiguration.delay, blinkConfiguration.duration, blinkConfiguration.timeUnit)
            }
        }
    }


}