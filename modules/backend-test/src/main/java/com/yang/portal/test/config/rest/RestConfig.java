package com.yang.portal.test.config.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Collections;

@Configuration
public class RestConfig {

    @Lazy
    @Bean
    @Scope("prototype")
    public RestTemplateBuilder restTemplateBuilder(){
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.additionalInterceptors(Collections.singletonList(new RequestInterceptor()));
        return restTemplateBuilder;
    }
}
