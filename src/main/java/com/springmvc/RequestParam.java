package com.springmvc;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface RequestParam {

    Class<?> type();

    boolean validate() default false;

    ContentTypeEnum contentType() default ContentTypeEnum.JSON;

    boolean required() default true;

    String name() default "";
}
