package com.chendecong.senior4.week2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 注册静态资源访问路径，以及路径指向的实际地址
        registry.addResourceHandler("/js/**").addResourceLocations("file:F:\\pic\\");
    }


}
