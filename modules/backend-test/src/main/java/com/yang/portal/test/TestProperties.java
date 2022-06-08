package com.yang.portal.test;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "test")
@Data
@ToString
public class TestProperties {

    private String accountId;
    private People people;
    private List<String> list;
    private Map<String,String> map;

    @Data
    public static class People{

        private String name;
        private int age;
    }
}
