package it.giaquinto.springberry.component

import com.pi4j.Pi4J
import com.pi4j.context.Context
import com.pi4j.library.pigpio.PiGpio
import com.pi4j.platform.Platform
import com.pi4j.plugin.linuxfs.provider.i2c.LinuxFsI2CProvider
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalInputProvider
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalOutputProvider
import com.pi4j.plugin.pigpio.provider.pwm.PiGpioPwmProvider
import com.pi4j.plugin.pigpio.provider.serial.PiGpioSerialProvider
import com.pi4j.plugin.pigpio.provider.spi.PiGpioSpiProvider
import com.pi4j.plugin.raspberrypi.platform.RaspberryPiPlatform
import com.pi4j.provider.Provider
import it.giaquinto.springberry.model.log.LogMessage
import it.giaquinto.springberry.model.raspberry.component.RaspBerryLedComponent
import it.giaquinto.springberry.model.raspberry.pin.IncorrectPhysicalPinSpecifiedException
import it.giaquinto.springberry.model.raspberry.pin.RaspberryEnumPin
import it.giaquinto.springberry.model.raspberry.pin.RaspberryPin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Scope
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.CompletableFuture

@Component
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
open class Pi4JComponent @Autowired constructor(private val logger: SpringBerryLoggerComponent) {
    private val piGpio: PiGpio = PiGpio.newNativeInstance()
    private val pi4j: Context = Pi4J
        .newContextBuilder()
        .noAutoDetect()
        .add(object : RaspberryPiPlatform() {
            override fun getProviders(): Array<String> {
                return arrayOf()
            }
        })
        .add(
            PiGpioDigitalInputProvider.newInstance(piGpio),
            PiGpioDigitalOutputProvider.newInstance(piGpio),
            PiGpioPwmProvider.newInstance(piGpio),
            PiGpioSerialProvider.newInstance(piGpio),
            PiGpioSpiProvider.newInstance(piGpio),
            LinuxFsI2CProvider.newInstance()
        )
        .build()
    private var physicalPinMap: Map<Int, RaspberryPin>? = null

    init {
        makeMap().thenAccept { map: TreeMap<Int, RaspberryPin>? ->
            physicalPinMap = map
            logger.writeLog(LogMessage("Map of pins correctly created"))
        }
    }

    val platform: Platform
        get() = pi4j!!.getPlatform()
    val providers: Map<String, Provider<*, *, *>>?
        get() = if (pi4j?.providers() == null) {
            null
        } else pi4j.providers().all()

    @Async
    open fun getRaspBerryLedComponent(pin: RaspberryEnumPin?): CompletableFuture<RaspBerryLedComponent> {
        return CompletableFuture.supplyAsync { RaspBerryLedComponent(pi4j, pin!!) }
    }

    @Async
    open fun makeMap(): CompletableFuture<TreeMap<Int, RaspberryPin>> {
        return CompletableFuture.supplyAsync {
            val temp = TreeMap<Int, RaspberryPin>()
            for (i in 0..40) {
                try {
                    temp[i] = RaspberryPin.fromPhysicalPin(i)
                } catch (e: IncorrectPhysicalPinSpecifiedException) {
                    throw RuntimeException(e)
                }
            }
            temp
        }
    }
}