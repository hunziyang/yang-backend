package com.yang.portal.core.mvc;

import com.yang.portal.core.CoreConstant;
import com.yang.portal.core.annotation.YangController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.annotation.Annotation;
import java.util.function.Predicate;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(CoreConstant.PathPrefix.YANG_CONTROLLER,
                pathPrefixPredicate(YangController.class));
    }

    private Predicate<Class<?>> pathPrefixPredicate(Class<? extends Annotation>... annotations) {
        return controller -> {
            for (Class<? extends Annotation> annotation : annotations) {
                if (controller.isAnnotationPresent(annotation)) {
                    return true;
                }
            }
            return false;
        };
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
