package org.springframework.boot.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("restful")
/**
 * HelloWorld Restful controller
 * @author  xiaowen
 */
public class HelloWorldRestController {

    @RequestMapping("/helloWorld")
    public Map<String, String> helloWorld() {
        Map<String, String> result = new HashMap<>(1);
        result.put("result", "helloWorld");
        return result;
    }
}
