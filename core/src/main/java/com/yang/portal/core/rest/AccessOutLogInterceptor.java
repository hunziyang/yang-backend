package com.yang.portal.core.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class AccessOutLogInterceptor implements ClientHttpRequestInterceptor {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        AccessOutLog.AccessOutLogBuilder accessOutLogBuilder = AccessOutLog.builder();
        URI uri = request.getURI();
        String host = uri.getHost();
        try {
            accessOutLogBuilder.remoteAddr(InetAddress.getByName(host).getHostAddress());
        } catch (UnknownHostException exception) {
            accessOutLogBuilder.error(ExceptionUtils.getStackTrace(exception));
            printLog(accessOutLogBuilder.build());
            throw exception;
        }
        accessOutLogBuilder.host(host);
        accessOutLogBuilder.scheme(uri.getScheme());
        accessOutLogBuilder.port(uri.getPort());
        accessOutLogBuilder.method(request.getMethodValue());
        accessOutLogBuilder.url(extractUrlFromRequest(request));
        accessOutLogBuilder.body(resolveBodyByContentType(request, body));
        long startTime = System.currentTimeMillis();
        ClientHttpResponse response;
        try {
            response = execution.execute(request, body);
        } catch (UnknownHostException exception) {
            accessOutLogBuilder.responseStatus(599);
            accessOutLogBuilder.error(ExceptionUtils.getStackTrace(exception));
            printLog(accessOutLogBuilder.build());
            throw exception;
        }
        long endTime = System.currentTimeMillis();
        accessOutLogBuilder.responseStatus(response.getRawStatusCode());
        long responseTime = endTime - startTime;
        accessOutLogBuilder.responseTime((int) responseTime);
        accessOutLogBuilder.responseBodySize(response.getBody().available());
        printLog(accessOutLogBuilder.build());
        return response;
    }

    private String extractUrlFromRequest(HttpRequest request) {
        URI requestURI = request.getURI();
        String url = requestURI.getPath();
        String query = requestURI.getQuery();
        if (query != null) {
            url = String.format("%s?%s", requestURI.getPath(), query);
        }

        return url;
    }

    private Object resolveBodyByContentType(HttpRequest request, byte[] bodyBytes) throws IOException {
        Object body = null;
        if (ArrayUtils.isEmpty(bodyBytes)) {
            return null;
        } else {
            MediaType contentType = request.getHeaders().getContentType();
            if (contentType == null) {
                return null;
            } else {
                if (contentType.includes(MediaType.APPLICATION_FORM_URLENCODED)) {
                    body = new String(bodyBytes, StandardCharsets.UTF_8);
                }

                if (contentType.includes(MediaType.APPLICATION_JSON)) {
                    body = this.objectMapper.readValue(bodyBytes, Object.class);
                }

                return body;
            }
        }
    }

    private void printLog(AccessOutLog accessOutLog) throws JsonProcessingException {
        try {
            log.warn("access out log:{}", objectMapper.writeValueAsString(accessOutLog));
        } catch (JsonProcessingException exception) {
            log.error("Failed to print access out log", exception);
            throw exception;
        }
    }
}
