package it.giaquinto.springberry

import it.giaquinto.springberry.model.builder.connector.SpringBerryConnectorBuilder
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.annotation.Bean

@SpringBootApplication
open //@EnableAsync

class SpringBerryApplication {
    @Bean
    open fun servletContainer(): TomcatServletWebServerFactory {
        val tomcatServletWebServerFactory = TomcatServletWebServerFactory()
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(SpringBerryConnectorBuilder().defaultBuild())
        return tomcatServletWebServerFactory
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringBerryApplication::class.java, *args)
        }
    }
}