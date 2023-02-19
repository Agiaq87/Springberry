package it.giaquinto.springberry.common.logger.processor

import com.google.auto.service.AutoService
import java.io.PrintWriter
import java.util.stream.Collectors.joining
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement

@AutoService(Processor::class)
@SupportedSourceVersion(SourceVersion.RELEASE_1)
@SupportedAnnotationTypes("it.giaquinto.springberry.spring.annotation.SpringBerryModelBuilder")
class SpringBerryModelBuilderProcessor : AbstractProcessor() {
    override fun process(annotations: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment?): Boolean {
        annotations?.forEach { annotation ->
            roundEnv?.getElementsAnnotatedWith(annotation)?.forEach(this::generateBuilderFile)
        }

        return true
    }

    private fun generateBuilderFile(e: Element) = with(e) {
        val className: String = e.simpleName.toString()
        val packageName: String = e.enclosingElement.toString()
        val builderClassName = "${simpleName}Builder"
        val builderFullName = "${packageName}.$builderClassName"
        val fields = enclosedElements.filter { AnnotationTarget.FIELD.equals(it.kind) }

        try {
            PrintWriter(processingEnv.filer.createSourceFile(builderFullName).openWriter()).apply {
                println("package $packageName \n public class $builderClassName {")

                fields.forEach {
                    println("\tprivate ${it.asType()} ${it.simpleName};")
                }

                fields.forEach {
                    println("\tpublic $builderClassName ${it.simpleName}(${it.asType()} ${it.simpleName}) {")
                    println("\t\tthis.${it.simpleName} = ${it.simpleName};\n\t\treturn this;}")
                }

                println(
                    "\tpublic $className build() {\n\t\t return new $className(${
                        fields.stream().map(Element::getSimpleName).collect(joining(", "))
                    });\n\t}"
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}