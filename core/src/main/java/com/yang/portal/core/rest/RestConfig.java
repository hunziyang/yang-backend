package com.yang.portal.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RestConfig {

    @Autowired
    private AccessOutLogInterceptor accessOutLogInterceptor;

    @Bean("newRestTemplateBuilder")
    public RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer){
        return configurer
                .configure(new RestTemplateBuilder())
                .additionalInterceptors(accessOutLogInterceptor)
                .setConnectTimeout(Duration.ofSeconds(1));
    }
}
