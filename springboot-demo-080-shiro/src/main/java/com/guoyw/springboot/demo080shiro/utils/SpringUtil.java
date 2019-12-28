package com.guoyw.springboot.demo080shiro.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring上下文工具类
 * @author: guoyw
 * create: 2019-12-28 09:46
 **/
@Component
@Slf4j
public class SpringUtil implements ApplicationContextAware{
  
  private static ApplicationContext context;
  /**
   * Spring在bean初始化后会判断是不是ApplicationContextAware的子类
   * 如果该类是,setApplicationContext()方法,会将容器中ApplicationContext作为参数传入进去
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
    log.warn("applicationContext正在初始化,application:"+applicationContext);
    context = applicationContext;
  }
  /**
   * 通过Name返回指定的Bean
   */
  public static <T> T getBean(Class<T> beanClass) {
    return context.getBean(beanClass);
  }
}
