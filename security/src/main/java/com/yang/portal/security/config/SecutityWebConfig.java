package com.yang.portal.security.config;

import com.yang.portal.security.SecurityConstant;
import com.yang.portal.security.annotation.AnonymousController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.annotation.Annotation;
import java.util.function.Predicate;

@Configuration
public class SecutityWebConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(SecurityConstant.PathPrefix.ANONYMOUS_CONTROLLER,
                pathPrefixPredicate(AnonymousController.class));
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
}
