package com.github.qhwhc.core.starter.config;

import com.github.qhwhc.core.starter.properties.CoreProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CoreProperties.class)
public class CoreAutoConfiguration {

}
