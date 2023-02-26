package it.giaquinto.springberry.spring.configuration

import it.giaquinto.springberry.spring.component.SpringBerryInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@EnableWebMvc
@Configuration
@ComponentScan("it.giaquinto.springberry.spring.component")
open class SpringBerryInterceptorConfig(@Autowired private val springBerryInterceptor: SpringBerryInterceptor) :
    WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(springBerryInterceptor)
    }
}