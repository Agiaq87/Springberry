package it.giaquinto.springberry.common.logger.processor

import com.google.auto.service.AutoService
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@AutoService(Processor::class)
@SupportedSourceVersion(SourceVersion.RELEASE_1)
@SupportedAnnotationTypes("it.giaquinto.springberry.spring.annotation.InjectSpringBerryLogger")
class SpringBerryLoggerProcessor : AbstractProcessor() {
    override fun process(annotations: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment?): Boolean {
        TODO("Not yet implemented")
    }
}