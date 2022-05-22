package com.folautech.chat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RestMVCConfig {

    @Value("${resttemplate.timeout:100000}")
    private int restTemplateTimeout;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("*");
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                // TODO Auto-generated method stub
                // WebMvcConfigurer.super.addResourceHandlers(registry);

                registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

                registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
            }

        };
    }


//    @Profile("dev")
//    @Bean
//    public OpenAPI openDevAPI() {
//        return new OpenAPI().addServersItem(new Server().url("https://dev-api.poochapp.net/v1"));
//    }
//
//    @Profile("prod")
//    @Bean
//    public OpenAPI openProdAPI() {
//        return new OpenAPI().addServersItem(new Server().url("https://prod-api.poochapp.net/v1"));
//    }

}
