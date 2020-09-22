package com.bookshop.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${resources.location}")
    private String resourcesLocation;
    @Value("${resources.uri_path:}")
    private String resourcesUriPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            resourcesLocation = "file:D:\\"+resourcesLocation.replace('/', '\\');
        } else if (os.contains("linux")) {
            resourcesLocation = "file:///home/ec2-user"+resourcesLocation;
        }

        registry.addResourceHandler(resourcesUriPath+"/**")
                .addResourceLocations( resourcesLocation);

    }

}