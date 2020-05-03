package com.serverconsumer.hystrix;

import com.serverconsumer.service.RemoteService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class RemoteHystrix implements RemoteService {

    @Override
    public String hello(@RequestParam String name) {
        return "请求失败, 进入熔断！！！";
    }
}
