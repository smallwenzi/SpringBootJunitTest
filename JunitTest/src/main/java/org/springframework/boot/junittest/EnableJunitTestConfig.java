package org.springframework.boot.junittest;

import java.lang.annotation.*;

import org.springframework.context.annotation.Import;

/**
 * 
 * 开启EnableJunitTestConfig
 * 
 * @Author xiaowen
 */
@Import(BeanConfig.class)
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableJunitTestConfig {}
