package it.giaquinto.springberry;

import it.giaquinto.springberry.model.builder.connector.SpringBerryConnectorBuilder;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.DefaultManagedTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class SpringBerryApplication implements AsyncConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBerryApplication.class, args);
    }

    @Override
    public Executor getAsyncExecutor() {
        return new DefaultManagedTaskExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return AsyncConfigurer.super.getAsyncUncaughtExceptionHandler();
    }

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        final TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(new SpringBerryConnectorBuilder().defaultBuild());
        return tomcatServletWebServerFactory;
    }

}
