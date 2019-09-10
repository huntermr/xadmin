package com.xadmin.admin.annotation;


import com.xadmin.admin.enums.OpType;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpLog {
    String description()  default "";
    OpType opType() default OpType.OTHER;
    boolean isSaveParams() default true;
}