package com.guoyw.springboot.demo120redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author: guoyw
 * create: 2020-01-09 11:16
 **/
@Configuration
@EnableCaching//开启注解
public class RedisConfig extends CachingConfigurerSupport{
  
  
  private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);
  // 自定义的配置类， 存放了通道地址
  @Autowired
  private BaseConfig baseConfig;
  
  /**
   *@参数
   *@返回值
   *@创建人  cx
   *@创建时间
   *@描述   //初始化监听器
   */
  @Bean
  RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                          MessageListenerAdapter listenerAdapter) {
    
    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    //配置监听通道
    container.addMessageListener(listenerAdapter, new PatternTopic(baseConfig.getRedisAisle()));// 通道的名字
    logger.info("初始化监听成功，监听通道：【"+baseConfig.getRedisAisle()+"】");
    return container;
  }
  
  /**
   *@参数
   *@返回值
   *@创建人  cx
   *@创建时间
   *@描述 利用反射来创建监听到消息之后的执行方法
   */
  @Bean
  MessageListenerAdapter listenerAdapter(RedisService receiver) {
    return new MessageListenerAdapter(receiver, "receiveMessage");
  }

//    /**
//     *@参数
//     *@返回值
//     *@创建人  cx
//     *@创建时间
//     *@描述 控制线程用的
//     */
//    @Bean
//    Receiver receiver(CountDownLatch latch) {
//        return new Receiver(latch);
//    }
//
//    @Bean
//    CountDownLatch latch() {
//        return new CountDownLatch(1);
//    }
  
  /**
   *@参数
   *@返回值
   *@创建人  cx
   *@创建时间
   *@描述   //使用默认的工厂初始化redis操作String模板
   */
  @Bean
  StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
    return new StringRedisTemplate(connectionFactory);
  }
  /**
   *@参数
   *@返回值
   *@创建人  cx
   *@创建时间
   *@描述   //使用默认的工厂初始化redis操作map模板
   */
  @Bean
  RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
    
    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    jackson2JsonRedisSerializer.setObjectMapper(om);
    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    template.setConnectionFactory(connectionFactory);
    template.setKeySerializer(jackson2JsonRedisSerializer);
    template.setValueSerializer(jackson2JsonRedisSerializer);
    template.setHashKeySerializer(jackson2JsonRedisSerializer);
    template.setHashValueSerializer(jackson2JsonRedisSerializer);
    template.afterPropertiesSet();
    return template;
    
  }
  
}
