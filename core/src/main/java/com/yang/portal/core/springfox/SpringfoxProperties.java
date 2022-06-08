package com.yang.portal.core.springfox;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("swagger")
public class SpringfoxProperties {

    private boolean enable;
    private String applicationName;
    private String applicationVersion;
    private String applicationDescription;
    private String tryHost;
    private String contactName;
    private String contactEmail;
}
