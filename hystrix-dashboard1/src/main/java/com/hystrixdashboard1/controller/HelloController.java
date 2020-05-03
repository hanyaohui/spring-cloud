package com.hystrixdashboard1.controller;

import com.hystrixdashboard1.service.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/consumer")
public class HelloController {

    @Autowired
    RemoteService remoteService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam String name) {
        return remoteService.hello(name);
    }
}
