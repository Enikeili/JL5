package jlab5;

import java.lang.annotation.*;

/**
 * MyAnnotation AutoInjectable hasn't variables
 * @author enikeili
 */
@Target(value=ElementType.FIELD)
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
public @interface AutoInjectable
{
}