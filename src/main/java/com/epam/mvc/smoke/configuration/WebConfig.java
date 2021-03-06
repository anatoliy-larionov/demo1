package com.epam.mvc.smoke.configuration;

import com.epam.mvc.smoke.interceptor.AdminInterceptor;
import com.epam.mvc.smoke.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private AuthInterceptor authInterceptor;
    private AdminInterceptor adminInterceptor;

    @Autowired
    public WebConfig(AuthInterceptor authInterceptor, AdminInterceptor adminInterceptor) {
        this.authInterceptor = authInterceptor;
        this.adminInterceptor = adminInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**").
                excludePathPatterns("/authorization", "/registration");
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin");
    }
}
