package it.giaquinto.springberry.raspberry.controller

import com.pi4j.context.Context
import com.pi4j.io.gpio.digital.DigitalOutput
import it.giaquinto.springberry.raspberry.cancelIfActive
import it.giaquinto.springberry.raspberry.loop
import it.giaquinto.springberry.raspberry.makeDigitalOutput
import it.giaquinto.springberry.raspberry.model.pin.RaspBerryPin
import it.giaquinto.springberry.raspberry.model.pin.configuration.BlinkConfiguration
import kotlinx.coroutines.*
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

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
        greenJob = blink(greenLed, greenJob, BlinkConfiguration.Normal)
        yellowJob = blink(yellowLed, yellowJob, BlinkConfiguration.Warning)
        redJob = blink(redLed, redJob, BlinkConfiguration.Error)
    }

    private fun blink(
        led: DigitalOutput,
        job: Job?,
        blinkConfiguration: BlinkConfiguration,
    ): Job {
        job?.cancelIfActive()

        return coroutineScope.launch {
            loop {
                led.on()
                Thread.sleep(blinkConfiguration.delay)
                led.off()
                Thread.sleep(blinkConfiguration.duration)
            }
        }
    }


}