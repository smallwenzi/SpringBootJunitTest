package org.springframework.boot.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("view")
/**
 * HelloWorld  controller
 * @author  xiaowen
 */
public class HelloWorldController {

    @RequestMapping("/helloWorld")
    public String helloWorld(Model model) {
        model.addAttribute("value", "helloWorld");
        return "helloWorld";
    }
}
