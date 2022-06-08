package com.yang.portal.core.springfox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

@Configuration
public class SpringfoxConfig {

    private static final String TITLE_SUFFIX = "Restful APIs";
    private static final String APIKEY_NAME = "Authorization";
    private static final String APIKEY_KEY_NAME = "Authorization";
    private static final String APIKEY_PASS_AS = "header";
    private static final String AUTHORIZATION_SCOPE = "global";
    private static final String BASE_PACKAGE = "com.yang.portal";

    @Bean
    public Docket docket(ApiInfo apiInfo, SpringfoxProperties springfoxProperties) {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo)
                .enable(springfoxProperties.isEnable())
                .securitySchemes(Collections.singletonList(new ApiKey(APIKEY_NAME, APIKEY_KEY_NAME, APIKEY_PASS_AS)))
                .securityContexts(securityContexts())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .build();
    }

    @Bean
    public ApiInfo apiInfo(SpringfoxProperties springfoxProperties) {
        return new ApiInfoBuilder()
                .title(String.format("%s%s", springfoxProperties.getApplicationName(), TITLE_SUFFIX))
                .description(springfoxProperties.getApplicationDescription())
                .contact(new Contact(springfoxProperties.getContactName(), null, springfoxProperties.getContactEmail()))
                .termsOfServiceUrl(springfoxProperties.getTryHost())
                .version(springfoxProperties.getApplicationVersion())
                .build();
    }

    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(Collections.singletonList(new SecurityReference(APIKEY_NAME, new AuthorizationScope[]{new AuthorizationScope(AUTHORIZATION_SCOPE, "")})))
                        .build()
        );
    }
}
