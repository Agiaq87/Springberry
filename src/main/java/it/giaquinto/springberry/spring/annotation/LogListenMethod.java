package it.giaquinto.springberry.spring.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface LogListenMethod {
    String methodName();
}
