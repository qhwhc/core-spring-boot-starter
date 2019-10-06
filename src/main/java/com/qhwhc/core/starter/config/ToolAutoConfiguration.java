package com.qhwhc.core.starter.config;

import com.qhwhc.core.starter.properties.ToolProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ToolProperties.class)
public class ToolAutoConfiguration {

}
