package com.yang.portal.test.config.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.portal.core.jackson.JacksonConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

@Component
@Slf4j
public class RequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        URI uri = request.getURI();
        String host = uri.getHost();
        int port = uri.getPort();
        ClientHttpResponse execute = execution.execute(request, body);
        InputStream inputStream = execute.getBody();
        ObjectMapper objectMapper = new JacksonConfig().objectMapper();
        Object o = objectMapper.readValue(inputStream, Object.class);
        log.warn("body:{}",o);
        return execute;
    }
}
