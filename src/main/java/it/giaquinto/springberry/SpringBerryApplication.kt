package it.giaquinto.springberry

import it.giaquinto.springberry.component.SpringBerryLoggerComponent
import it.giaquinto.springberry.model.builder.connector.SpringBerryConnectorBuilder
import it.giaquinto.springberry.model.log.LogMessage
import it.giaquinto.springberry.model.log.LogMessageFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
//@EnableAsync
open class SpringBerryApplication {
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
            SpringBerryLoggerComponent.instance().startLog()
            SpringBerryLoggerComponent.instance().writeLog(LogMessageFactory.Generic.direct("EEEE"))
        }
    }
}