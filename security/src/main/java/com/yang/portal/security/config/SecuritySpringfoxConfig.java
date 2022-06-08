package com.yang.portal.security.config;

import com.yang.portal.core.CoreConstant;
import com.yang.portal.core.springfox.SpringfoxProperties;
import com.yang.portal.security.SecurityConstant;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

@Configuration
@Profile("!local")
public class SecuritySpringfoxConfig {

    @Autowired
    private SpringfoxProperties springfoxProperties;

    @Bean
    public Docket securityDocket(ApiInfo buildApiInfo, List<SecurityContext> securityContexts) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(SecurityConstant.SecuritySpringFox.SECURITY_GROUP_NAME)
                .apiInfo(buildApiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SecurityConstant.SecuritySpringFox.SECURITY_BASE_PACKAGE))
                .build()
                .securitySchemes(Collections.singletonList(new ApiKey(
                        SecurityConstant.SecuritySpringFox.APIKEY_NAME,
                        SecurityConstant.SecuritySpringFox.APIKEY_KEY_NAME,
                        In.HEADER.toValue())))
                .securityContexts(securityContexts);
    }

    @Bean
    public Docket moduleDocket(ApiInfo buildApiInfo, List<SecurityContext> securityContexts) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(SecurityConstant.SecuritySpringFox.MODULE_GROUP_NAME)
                .apiInfo(buildApiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage(String.format("%s.%s", CoreConstant.SpringFox.BASE_PACKAGE, springfoxProperties.getApplicationName())))
                .build()
                .securitySchemes(Collections.singletonList(new ApiKey(
                        SecurityConstant.SecuritySpringFox.APIKEY_NAME,
                        SecurityConstant.SecuritySpringFox.APIKEY_KEY_NAME,
                        In.HEADER.toValue())))
                .securityContexts(securityContexts);
    }

    @Bean
    public List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(Collections.singletonList(new SecurityReference(SecurityConstant.SecuritySpringFox.APIKEY_NAME,
                                new AuthorizationScope[]{new AuthorizationScope(SecurityConstant.SecuritySpringFox.AUTHORIZATION_SCOPE, "")})))
                        .forPaths(path ->
                                !SecurityConstant.SecuritySpringFox.REGISTER_URL.equals(path)
                                        && !path.startsWith(SecurityConstant.SecuritySpringFox.ANONYMOUS_URL))
                        .build()
        );
    }


}
