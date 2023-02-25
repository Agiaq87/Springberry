package it.giaquinto.springberry.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Controller
@ResponseBody
public @interface SpringBerryRestController {

    @AliasFor(annotation = Controller.class)
    String value() default "";


}
