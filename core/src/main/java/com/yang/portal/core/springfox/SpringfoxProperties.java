package com.yang.portal.core.springfox;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Component
@Validated
@Data
@ConfigurationProperties("swagger")
public class SpringfoxProperties {
    @NotBlank
    private String applicationName;
    @NotBlank
    private String applicationDescription;
}
