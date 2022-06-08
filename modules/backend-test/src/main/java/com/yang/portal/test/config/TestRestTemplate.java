package com.yang.portal.test.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;

@Configuration
@Slf4j
public class TestRestTemplate {


    @Bean
    public RestOperations testRestOperations(RestTemplateBuilder restTemplateBuilder) {
        System.out.println("address1:" + restTemplateBuilder);
        return restTemplateBuilder.rootUri("http://127.0.0.1/test").build();
    }

    @Bean
    public RestOperations apiRestOperations(RestTemplateBuilder restTemplateBuilder) {
        System.out.println("address2:" + restTemplateBuilder);
        return restTemplateBuilder.rootUri("http://127.0.0.1/api").build();
    }
}
