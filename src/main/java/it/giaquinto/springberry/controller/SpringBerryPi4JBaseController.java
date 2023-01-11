package it.giaquinto.springberry.controller;

import it.giaquinto.springberry.component.Pi4JComponent;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class SpringBerryPi4JBaseController extends SpringBerryBaseController {
    private Pi4JComponent pi4JComponent;

    @Autowired
    public void setPi4JComponent(Pi4JComponent pi4JComponent) {
        this.pi4JComponent = pi4JComponent;
    }

    public Pi4JComponent getPi4JComponent() {
        return pi4JComponent;
    }

}
