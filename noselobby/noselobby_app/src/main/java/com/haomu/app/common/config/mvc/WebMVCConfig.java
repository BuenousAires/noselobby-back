package com.haomu.app.common.config.mvc;


import com.haomu.app.common.interceptor.AppApiInterceptor;
import com.haomu.common.common.config.property.IOProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Resource
    private AppApiInterceptor appApiInterceptor;  // api拦截器

    @Resource
    private IOProperty ioProperty;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(this.appApiInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 静态图片的位置 // eg: windows: file:D/Desktop/image/  Linux或Mac系统: file:/home/naicha/naicha-img/
        registry.addResourceHandler("/static/image/**")
                .addResourceLocations("file:" + ioProperty.getImageFileRootPath());
    }
}
