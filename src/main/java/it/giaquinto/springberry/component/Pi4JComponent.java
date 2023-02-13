package it.giaquinto.springberry.component;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.library.pigpio.PiGpio;
import com.pi4j.platform.Platform;
import com.pi4j.plugin.linuxfs.provider.i2c.LinuxFsI2CProvider;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalInputProvider;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalOutputProvider;
import com.pi4j.plugin.pigpio.provider.pwm.PiGpioPwmProvider;
import com.pi4j.plugin.pigpio.provider.serial.PiGpioSerialProvider;
import com.pi4j.plugin.pigpio.provider.spi.PiGpioSpiProvider;
import com.pi4j.plugin.raspberrypi.platform.RaspberryPiPlatform;
import com.pi4j.provider.Provider;
import it.giaquinto.springberry.model.log.LogMessage;
import it.giaquinto.springberry.model.log.LogMessageFactory;
import it.giaquinto.springberry.model.raspberry.pin.*;
import it.giaquinto.springberry.model.raspberry.component.RaspBerryLedComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

@Component
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Pi4JComponent {
    private final SpringBerryLoggerComponent logger;
    private final PiGpio piGpio;
    private final Context pi4j;

    private Map<Integer, RaspberryPin> physicalPinMap;

    @Autowired
    public Pi4JComponent(final SpringBerryLoggerComponent logger) {
        this.logger = logger;
        piGpio = PiGpio.newNativeInstance();
        pi4j = Pi4J
                .newContextBuilder()
                .noAutoDetect()
                .add(new RaspberryPiPlatform() {
                    @Override
                    protected String[] getProviders() {
                        return new String[]{};
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
                .build();


        try {
            makeMap().thenAccept(
                    map -> {
                        physicalPinMap = map;
                        logger.writeLog(new LogMessage("Map of pins correctly created"));
                    }
            );
        } catch (final IncorrectPhysicalPinSpecifiedException e) {
            logger.writeLog(new LogMessage("IncorrectPhysicalPinSpecifiedException caught"));
        }


    }

    public Context getPi4j() {
        return pi4j;
    }

    public Platform getPlatform() {
        return pi4j.getPlatform();
    }

    public Map<String, Provider> getProviders() {
        if (pi4j == null || pi4j.providers() == null) {
            return null;
        }

        return pi4j.providers().all();
    }

    @Async
    public CompletableFuture<RaspBerryLedComponent> getRaspBerryLedComponent(final RaspberryEnumPin pin) {
        return CompletableFuture.supplyAsync(
                () -> new RaspBerryLedComponent(pi4j, pin)
        );
    }

    @Async
    CompletableFuture<TreeMap<Integer, RaspberryPin>> makeMap() throws IncorrectPhysicalPinSpecifiedException {
        final TreeMap<Integer, RaspberryPin> temp = new TreeMap<>();

        for (int i = 0; i <= 40; i++) {
            temp.put(i, RaspberryPin.fromPhysicalPin(i));
        }


        return CompletableFuture.supplyAsync(
                () -> temp
        );
    }
}
