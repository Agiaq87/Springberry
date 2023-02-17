package it.giaquinto.springberry.spring.configuration

import it.giaquinto.springberry.spring.bean.springberrybean.HardwareSoftwareProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SpringBerryConfiguration {
    @Bean
    open fun hardwareSoftwareProperties(): HardwareSoftwareProperties = HardwareSoftwareProperties()
}