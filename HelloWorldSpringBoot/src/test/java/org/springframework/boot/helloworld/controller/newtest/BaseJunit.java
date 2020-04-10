package org.springframework.boot.helloworld.controller.newtest;

import org.springframework.boot.helloworld.Application;
import org.springframework.boot.junittest.AbstractBaseJunit;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 
 * 这个项目基础测试类
 * 
 * @Author xiaowen
 */
// 这里的Application是springboot的启动类名
@SpringBootTest(classes = Application.class)
// 继承 org.springframework.boot.junittest.AbstractBaseJunit
public class BaseJunit extends AbstractBaseJunit {}
