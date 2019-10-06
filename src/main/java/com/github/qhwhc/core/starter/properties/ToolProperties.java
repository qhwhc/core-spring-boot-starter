package com.github.qhwhc.core.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "qhwhc.tool")
public class ToolProperties {
    private String enable = "true";
}
