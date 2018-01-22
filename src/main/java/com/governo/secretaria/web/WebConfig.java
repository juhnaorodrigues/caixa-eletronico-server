//package com.governo.secretaria.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.ResourceProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//import org.springframework.http.CacheControl;
//import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
//import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.resource.PathResourceResolver;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by Juhnao on 1/21/18.
// */
//@Configuration
//@EnableConfigurationProperties({ResourceProperties.class})
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("home");
//        registry.addViewController("/index").setViewName("index");
//    }
//}
