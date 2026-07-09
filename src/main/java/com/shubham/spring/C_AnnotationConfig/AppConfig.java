package com.shubham.spring.C_AnnotationConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.shubham.spring.C_PureAnnotation")
public class AppConfig {
}
///Write component-scan here instead of xml file