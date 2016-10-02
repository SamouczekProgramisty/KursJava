package pl.samouczekprogramisty.kursjava.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface SampleFieldAnnotation {
    String id();
}
