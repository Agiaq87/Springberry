package it.giaquinto.springberry;

import it.giaquinto.springberry.component.SpringBerryLoggerComponent;
import it.giaquinto.springberry.model.builder.connector.SpringBerryConnectorBuilder;
import it.giaquinto.springberry.model.log.LogMessageFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class SpringBerryApplication{

    public static void main(String[] args) {
        SpringApplication.run(SpringBerryApplication.class, args);
        SpringBerryLoggerComponent.instance().startLog();
    }

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        final TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(new SpringBerryConnectorBuilder().defaultBuild());
        return tomcatServletWebServerFactory;
    }

}
