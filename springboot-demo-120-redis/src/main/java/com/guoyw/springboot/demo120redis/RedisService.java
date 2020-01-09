package com.guoyw.springboot.demo120redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author: guoyw
 * create: 2020-01-09 11:23
 **/

public class RedisService extends BaseService{
  
  @Autowired
  private StringRedisTemplate template;
  @Autowired
  private BaseConfig baseConfig;
  @Autowired
  RedisService redisService;
  
  /**
   *@参数
   *@返回值
   *@创建人  cx
   *@创建时间
   *@描述       向默认通道发送消息
   */
  public void setMessage( Long funiqueid) {
    
    template.convertAndSend(baseConfig.getRedisAisle(),
      baseConfig.getRedisMessageName() +funiqueid);
  }
  
  
  /**
   *@参数
   *@返回值
   *@创建人  cx
   *@创建时间
   *@描述       接受监听到的消息
   */
  public void receiveMessage(String message) {
    logger.info("接收redis通道消息："+message);
  }
  
}
