package com.guoyw.springboot.demo070interceptor.interceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: guoyw
 * create: 2019-12-24 11:45
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor{
  
 
  
  //排除不拦截的url
  private static final String[] excludePathPatterns = { "/api/login","/error"};
  
  /**
   * 预处理回调方法，实现处理器的预处理
   * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
  
    HttpServletRequest req = (HttpServletRequest)request;
    HttpServletResponse res = (HttpServletResponse)response;

    System.out.println("开始拦截.........");
    return true;
  }
  
  
}
