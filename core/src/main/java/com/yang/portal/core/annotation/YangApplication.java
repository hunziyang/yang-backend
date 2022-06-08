package com.yang.portal.core.annotation;

import com.yang.portal.Yang;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootApplication(
        scanBasePackageClasses = Yang.class,
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
public @interface YangApplication {
}
