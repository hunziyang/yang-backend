package com.yang.portal.core.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.portal.core.jackson.JacksonConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
@Slf4j
public class LogFilter implements Filter {

    private static final String REQUEST_UUID = "requestUUID";

    private ObjectMapper objectMapper = new JacksonConfig().objectMapper();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RequestWrapper requestWrapper = new RequestWrapper((HttpServletRequest) request);
        ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) response);
        getRequestUUID(response);
        long startTime = System.currentTimeMillis();
        chain.doFilter(requestWrapper, responseWrapper);
        log.warn("request and response info:{}", generateAccessLog(startTime, requestWrapper, responseWrapper));
        MDC.remove(REQUEST_UUID);
        MDC.clear();
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(responseWrapper.getContent());
        outputStream.flush();
        outputStream.close();
    }

    private void getRequestUUID(ServletResponse response) {
        String uuid = UUID.randomUUID().toString();
        String requestUUID = uuid.toUpperCase();
        MDC.put(REQUEST_UUID, requestUUID);
        ((HttpServletResponse) response).setHeader(REQUEST_UUID, requestUUID);
    }

    private AccessLog generateAccessLog(long startTime, RequestWrapper requestWrapper, ResponseWrapper responseWrapper) {
        long responseTime = System.currentTimeMillis() - startTime;
        return AccessLog.builder()
                .host(requestWrapper.getHeader("Host"))
                .userAgent(requestWrapper.getHeader("User-Agent"))
                .remoteAddr(requestWrapper.getRemoteAddr())
                .method(requestWrapper.getMethod())
                .url(extractUrlFromRequestWrapper(requestWrapper))
                .body(extractBodyFromRequestWrapper(requestWrapper))
                .responseTime((int) responseTime)
                .responseStatus(responseWrapper.getStatus())
                .startTime(startTime)
                .build();
    }

    private String extractUrlFromRequestWrapper(RequestWrapper requestWrapper) {
        String url = requestWrapper.getRequestURI();
        Map<String, String[]> parameterMap = requestWrapper.getParameterMap();
        if (!parameterMap.isEmpty()) {
            List<String> params = new ArrayList();
            Iterator iterator = parameterMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String[]> entry = (Map.Entry) iterator.next();
                Arrays.stream(entry.getValue()).forEach(value -> params.add(String.format("%s=%s", entry.getKey(), value)));
            }

            url = String.format("%s?%s", url, String.join("&", params));
        }
        return url;
    }

    private Object extractBodyFromRequestWrapper(RequestWrapper requestWrapper) {
        byte[] bodyBytes;
        try {
            bodyBytes = StreamUtils.copyToByteArray(requestWrapper.getInputStream());
        } catch (IOException e) {
            return null;
        }
        if (ArrayUtils.isEmpty(bodyBytes)) {
            return null;
        } else {
            String contentType = requestWrapper.getContentType();
            if (!StringUtils.isBlank(contentType) && !contentType.startsWith("text/plain")) {
                if (contentType.startsWith("application/json")) {
                    try {
                        return this.objectMapper.readValue(bodyBytes, Object.class);
                    } catch (Exception var5) {
                        return new String(bodyBytes, StandardCharsets.UTF_8);
                    }
                } else {
                    return contentType.startsWith("multipart/form-data") ? "[ignored]" : null;
                }
            } else {
                return new String(bodyBytes, StandardCharsets.UTF_8);
            }
        }
    }
}
