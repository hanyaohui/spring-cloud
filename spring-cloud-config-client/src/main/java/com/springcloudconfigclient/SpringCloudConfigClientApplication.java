package com.springcloudconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }

    /**
     * 读取配置：在无法找到对应属性的情况下将其跳过, 否则会启动失败
     * */
    //@Bean
    //public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
    //    PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
    //    c.setIgnoreUnresolvablePlaceholders(true);
    //    return c;
    //}

}
