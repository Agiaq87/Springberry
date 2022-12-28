package it.giaquinto.springberry.component;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import org.springframework.stereotype.Component;

@Component
public class Pi4JComponent {
    private final Context pi4j = Pi4J.newAutoContext();

}
