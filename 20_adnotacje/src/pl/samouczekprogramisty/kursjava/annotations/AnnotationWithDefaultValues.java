package pl.samouczekprogramisty.kursjava.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface AnnotationWithDefaultValues {
    String firstElement() default "someDefaultValue";
    int [] secondElement() default {1, 2, 3};
    float thirdElement();
}
