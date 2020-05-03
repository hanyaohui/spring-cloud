package com.serverproducter.controller;

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
        // 请求超时改造(用于zuul重试)
        //System.out.println("********请求来了********");
        //try {
        //    Thread.sleep(1000000);
        //} catch ( Exception e) {
        //
        //}
        return "hello, " + name + "！！！";
    }
}
