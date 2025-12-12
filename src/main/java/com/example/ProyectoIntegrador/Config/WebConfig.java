package com.example.ProyectoIntegrador.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String rutaBase = "file:///C:/Users/Usuario/Downloads/ProyectoIntegrador/uploads/";

        registry.addResourceHandler("/uploads/servicios/**")
                .addResourceLocations(rutaBase + "servicios/");

        registry.addResourceHandler("/uploads/chat/**")
                .addResourceLocations(rutaBase + "chat/");

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }
}