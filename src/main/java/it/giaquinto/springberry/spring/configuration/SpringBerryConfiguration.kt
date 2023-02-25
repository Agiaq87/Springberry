package it.giaquinto.springberry.spring.configuration

import it.giaquinto.springberry.spring.bean.springberrybean.HardwareSoftwareProperties
import it.giaquinto.springberry.spring.bean.springberrybean.utils.Mathematics
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SpringBerryConfiguration{
    @Bean
    open fun hardwareSoftwareProperties(): HardwareSoftwareProperties = HardwareSoftwareProperties()

    @Bean
    open fun mathUtils(): Mathematics = Mathematics()

}