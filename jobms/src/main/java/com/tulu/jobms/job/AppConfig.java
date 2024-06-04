package com.tulu.jobms.job;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    // load balanced is used with restTemplate
    @LoadBalanced
    // bean is used to manage this class in runTime
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
