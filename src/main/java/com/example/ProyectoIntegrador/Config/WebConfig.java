package com.example.ProyectoIntegrador.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String rutaProyecto = "file:///C:/Users/Usuario/Downloads/ProyectoIntegrador/uploads/";

        registry.addResourceHandler("/uploads/servicios/**")
                .addResourceLocations(rutaProyecto + "servicios/");

        registry.addResourceHandler("/uploads/chat/**")
                .addResourceLocations(rutaProyecto + "chat/");
    }
}