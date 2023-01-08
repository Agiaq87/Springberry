package it.giaquinto.springberry.controller;

import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;
import it.giaquinto.springberry.component.Pi4JComponent;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class SpringBerryPi4jController extends SpringBerryController {
    private Pi4JComponent pi4JComponent;

    @Autowired
    public void setPi4JComponent(Pi4JComponent pi4JComponent) {
        this.pi4JComponent = pi4JComponent;
    }

    public Pi4JComponent getPi4JComponent() {
        return pi4JComponent;
    }

    public DigitalOutput setupPin(final String id, final int address) {
        return pi4JComponent.getPi4j().create(
                DigitalOutput.newConfigBuilder(pi4JComponent.getPi4j())
                        .id(id)
                        .name(id.toUpperCase())
                        .address(address)
                        .shutdown(DigitalState.LOW)
                        .initial(DigitalState.LOW)
                        .provider("pigpio-digital-output")
        );
    }
}
