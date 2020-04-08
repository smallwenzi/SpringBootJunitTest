package org.springframework.boot.helloworld.controller.newTest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 *
 * HelloWorld Restful Testcontroller
 *
 * @Author xiaowen
 */

public class HelloWorldRestControllerTest extends BaseTest {
    /**
     * url地址返回json例子
     *
     * @See org.springframework.boot.helloworld.controller.HelloWorldController.helloWorld
     * @throws Exception
     */
    @Test
    public void testHelloWorld() throws Exception {
        Map<String, Object> resultMatchersMap = new HashMap<String, Object>();
        resultMatchersMap.put("result", "helloWorld");
        this.postUrl("/restful/helloWorld", resultMatchersMap);
    }
}
