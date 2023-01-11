package it.giaquinto.springberry.component;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.platform.Platform;
import com.pi4j.provider.Provider;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public final class Pi4JComponent {
    private final Context pi4j = Pi4J.newAutoContext();

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
}
