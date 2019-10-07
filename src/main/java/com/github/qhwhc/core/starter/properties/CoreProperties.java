package com.github.qhwhc.core.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "qhwhc.core")
public class CoreProperties {
    private String enable = "true";
}
