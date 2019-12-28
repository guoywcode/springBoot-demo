package com.guoyw.springboot.demo070interceptor.config;

import com.guoyw.springboot.demo070interceptor.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author: guoyw
 * create: 2019-12-24 17:59
 **/
@Configuration
public class WebConfig extends WebMvcConfigurationSupport{
  
  @Override
  protected void addInterceptors(InterceptorRegistry registry){
    registry.addInterceptor(new LoginInterceptor())
      .addPathPatterns("/api/**")
      .excludePathPatterns("/api/login")
      .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    super.addInterceptors(registry);
  }
}
