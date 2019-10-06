package com.github.qhwhc.core.starter.config;

import com.github.qhwhc.core.starter.properties.ToolProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ToolProperties.class)
public class ToolAutoConfiguration {

}
