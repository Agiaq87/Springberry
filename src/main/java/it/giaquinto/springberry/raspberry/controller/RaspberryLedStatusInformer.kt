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

class RaspberryLedStatusInformer(pi4jContext: Context, red: RaspBerryPin, green: RaspBerryPin, blue: RaspBerryPin) :
    RaspberryLedInformer {

    override val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    // GREEN
    // Default pin is 13 - BCM 27
    private val greenLed: DigitalOutput = pi4jContext.makeDigitalOutput(green)
    private val greenJob: Thread by lazy {
        Thread {
            loop {
                greenLed.on()
                Thread.sleep(BlinkConfiguration.Normal.delay)
                greenLed.off()
                Thread.sleep(BlinkConfiguration.Normal.duration)
            }
        }
    }

    // BLUE
    // Default pin is 15 - BCM 22
    private val blueLed: DigitalOutput = pi4jContext.makeDigitalOutput(blue)
    private var warningJob: Job? = null

    // RED
    // Default pin is 37 - BCM 26
    private val redLed: DigitalOutput = pi4jContext.makeDigitalOutput(red)
    private var errorJob: Job? = null

    // Green led for springberry start
    // Combine with red for warning
    // Combine with blue for turquoise

    fun onStart() = greenJob.start() // Run forever


    fun onWarning() =
        coroutineScope.launch {
            warningJob = blink(
                blueLed,
                BlinkConfiguration.Warning
            )
        }

    fun onError() =
        coroutineScope.launch {
            errorJob = blink(
                redLed,
                BlinkConfiguration.Error
            )
        }
}