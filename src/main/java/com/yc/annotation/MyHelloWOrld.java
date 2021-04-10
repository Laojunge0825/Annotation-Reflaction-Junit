package com.yc.annotation;

import java.lang.annotation.*;

/**
 * @program: ReflactionAndAnotation
 * @author: 作者
 * @create: 2021-03-30 18:44
 */
@Target(value={ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented  //生成的  java doc文档中是否保留这个注解
@Inherited  //子类是否可以继承  父类的注解
public @interface MyHelloWOrld {
}
