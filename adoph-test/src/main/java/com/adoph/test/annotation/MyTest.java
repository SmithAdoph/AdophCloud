package com.adoph.test.annotation;

import java.lang.annotation.*;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/5/31
 */
@Inherited
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {
    String name() default "dududu";
}
