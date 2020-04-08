package org.springframework.boot.helloworld.controller.newTest;

import org.springframework.boot.helloworld.Application;
import org.springframework.boot.junittest.AbstractBaseTest;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * 这个项目基础测试类
 * 
 * @Author xiaowen
 */
// 这里的Application是springboot的启动类名
@SpringBootTest(classes = Application.class)
// 继承AbstractBaseTest
public class BaseTest extends AbstractBaseTest {}
