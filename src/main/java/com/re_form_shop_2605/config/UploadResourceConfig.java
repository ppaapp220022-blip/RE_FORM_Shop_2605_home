package com.re_form_shop_2605.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class UploadResourceConfig implements WebMvcConfigurer {

    private final String uploadRoot;

    public UploadResourceConfig(@Value("${spring.servlet.multipart.location}") String uploadRoot) {
        this.uploadRoot = uploadRoot;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path uploadPostRoot = Paths.get(uploadRoot).toAbsolutePath().normalize().resolve("post");
        registry.addResourceHandler("/uploads/post/**")
                .addResourceLocations(uploadPostRoot.toUri().toString() + "/");
    }
}
