package com.springcloudconfigclient2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${hello}")
    private String hello;

    @RequestMapping("/getHello")
    public String getHello() {
        return this.hello;
    }
}
