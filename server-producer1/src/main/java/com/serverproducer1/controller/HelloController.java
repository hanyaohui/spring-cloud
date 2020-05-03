package com.serverproducer1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/producer")
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "hello, " + name + ", producer2";
    }
}
