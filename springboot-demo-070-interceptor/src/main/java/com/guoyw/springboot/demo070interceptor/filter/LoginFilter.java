package com.guoyw.springboot.demo070interceptor.filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author: guoyw
 * create: 2019-12-27 13:53
 **/
@Component
@Slf4j
public class LoginFilter implements Filter{
  //排除不拦截的url
  private static final String[] excludePathPatterns = {"/api/login"};
  
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException{
    
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse res = (HttpServletResponse) servletResponse;
    
    // 获取请求url地址，不拦截excludePathPatterns中的url
    String url = req.getRequestURI();
    log.info("url: " + url);
    if(!url.startsWith("/api/")){
      filterChain.doFilter(servletRequest, servletResponse);
      return;
    }
    if(Arrays.asList(excludePathPatterns).contains(url)){
      //放行，相当于第一种方法中LoginInterceptor返回值为true
      filterChain.doFilter(servletRequest, servletResponse);
      return;
    }
  
  
//    Map<String, String> map = new HashMap<>();
//    map.put("codeName", "LOGIN-00001");
//    map.put("msgName", "登录超时请重新登录。");
    
//    String token = req.getHeader("TOKEN");
//    if(token == null || token.isEmpty()){
////      throw new StoreManagementException("LOGIN-00001");
//
//      servletResponse.setCharacterEncoding("utf-8");
//      servletResponse.getWriter().print(JSONObject.toJSON(map));
//      return;
//    }
//    User user = userService.getByToken(token);
//    if(user == null){
////      throw new StoreManagementException("LOGIN-00001");
//      servletResponse.setCharacterEncoding("utf-8");
//      servletResponse.getWriter().print(JSONObject.toJSON(map));
//      return;
//    }
    filterChain.doFilter(servletRequest, servletResponse);
  }
  
  
}
