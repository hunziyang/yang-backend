package com.yang.portal.core.log;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessLog {
    @Builder.Default
    private String type = "access";
    private String remoteAddr;
    private String userAgent;
    private String host;
    private String method;
    private String url;
    private Object body;
    private long startTime;
    private int responseStatus;
    private int responseTime;
}
