package org.springframework.boot.helloworld.controller.newTest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.boot.junittest.constant.SystemConstant;

/**
 *
 * HelloWorld Testcontroller
 *
 * @Author xiaowen
 */
public class HelloWorldControllerTest extends BaseTest {
    /**
     * url地址返回view页面例子
     * 
     * @See org.springframework.boot.helloworld.controller.HelloWorldController.helloWorld
     * @throws Exception
     */
    @Test
    public void testHelloWorld() throws Exception {
        Map<String, Object> resultMatchersMap = new HashMap<String, Object>();
        // 检查 页面是否 helloWorld
        resultMatchersMap.put(SystemConstant.VIEW_NAME, "helloWorld");
        // 检查Model对象属性value 值是否是helloWorld
        resultMatchersMap.put("value", "helloWorld");
        // 请求地址
        this.postUrl("/view/helloWorld", resultMatchersMap);
    }
}
