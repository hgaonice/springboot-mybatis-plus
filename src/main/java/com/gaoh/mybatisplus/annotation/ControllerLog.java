package com.gaoh.mybatisplus.annotation;


import java.lang.annotation.*;

/**
 * @author gaoh
 * @version 1.0
 * @date 2019/7/30 15:40
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {
    /**
     * 描述
     * @return
     */
    String memo() default "";


    /**
     * 操作类型
     * @return
     */
    OperationType type() default OperationType.SPACE ;
}