package it.giaquinto.springberry;

import it.giaquinto.springberry.model.builder.connector.SpringBerryConnectorBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBerryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBerryApplication.class, args);
    }

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        final TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(new SpringBerryConnectorBuilder().defaultBuild());
        return tomcatServletWebServerFactory;
    }

}
