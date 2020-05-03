package com.hystrix_dashboard.service;

import com.hystrix_dashboard.hystrix.RemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "server-producer", fallback = RemoteHystrix.class)
public interface RemoteService {

    @RequestMapping("/producer/hello")
    String hello(@RequestParam String name);
}
