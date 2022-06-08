package com.yang.portal.core.rest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessOutLog {
    @Builder.Default
    private String type = "accessOut";
    private String remoteAddr;
    private String userAgent;
    private String host;
    private String method;
    private int port;
    private String scheme;
    private String url;
    private Object body;
    private long startTime;
    private int responseStatus;
    private int responseTime;
    private int responseBodySize;
    private String error;
}
