package com.serverproducer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerProducer1Application {

    public static void main(String[] args) {
        SpringApplication.run(ServerProducer1Application.class, args);
    }

}
