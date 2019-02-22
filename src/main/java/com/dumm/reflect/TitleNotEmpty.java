package com.dumm.reflect;
/**
 * Created by dumm on 2019/2/22.
 */

import java.lang.annotation.*;

/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm.reflect
 * @ClassName: TitleNotEmpty
 * @Description: java类作用描述
 * @Author: dumm
 * @Date： 2019/2/22
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD, })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TitleNotEmpty
{
    /**
     * 执行方法
     * @return
     */
    String message() default "未知";

}