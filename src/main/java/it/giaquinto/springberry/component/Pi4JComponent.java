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
import it.giaquinto.springberry.model.raspberry.pin.RaspberryPin;
import it.giaquinto.springberry.model.raspberry.component.RaspBerryLedComponent;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Component
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Pi4JComponent {
    private final PiGpio piGpio = PiGpio.newNativeInstance();
    private final Context pi4j = Pi4J
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
    public CompletableFuture<RaspBerryLedComponent> getRaspBerryLedComponent(final RaspberryPin pin) {
        return CompletableFuture.supplyAsync(
                () -> new RaspBerryLedComponent(pi4j, pin)
        );
    }
}
