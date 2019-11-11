package com.project.manager.config;

import com.project.manager.interceptor.MvcInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;

@Configuration
public class ApplicatonConfig implements WebMvcConfigurer {
    @Autowired
    private MvcInterceptor mvcInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mvcInterceptor).excludePathPatterns(
                "/**/css/**",
                "/**/js/**",
                "/**/images/**"
        ).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("/static/**")
                 .addResourceLocations("classpath:/static/");
    }
    @Bean
    public HttpMessageConverter<String> responseBodyConverter(){
     StringHttpMessageConverter converter=new StringHttpMessageConverter(Charset.forName("utf-8"));
     return converter;
    }
}
