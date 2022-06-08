package com.yang.portal.core.springfox;

import com.yang.portal.core.CoreConstant;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("!local")
public class SpringfoxConfig {

    /**
     * 本地地址： http://localhost:8080/swagger-ui.html
     *
     * @param buildApiInfo
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public Docket docket(ApiInfo buildApiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CoreConstant.SpringFox.BASE_PACKAGE))
                .build();
    }

    @Bean
    public ApiInfo buildApiInfo(SpringfoxProperties springfoxProperties) {
        return new ApiInfoBuilder()
                .title(String.format("%s %s", springfoxProperties.getApplicationName(), CoreConstant.SpringFox.TITLE_SUFFIX))
                .description(springfoxProperties.getApplicationDescription())
                .version("1.0")
                .build();
    }
}
