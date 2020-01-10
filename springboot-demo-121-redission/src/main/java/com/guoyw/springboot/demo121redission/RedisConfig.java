package com.guoyw.springboot.demo121redission;

import lombok.Data;
import lombok.ToString;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: guoyw
 * create: 2020-01-10 10:19
 **/
@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "spring.redis", ignoreUnknownFields = false)
public class RedisConfig{
  
  private String host;
  private String port;
  private String password;
  private int database = 0;
  
  /**
   * 等待节点回复命令的时间。该时间从命令发送成功时开始计时
   */
  private int timeout=3600;
  
  
  @Bean
  public RedissonClient getRedisson(){
    
    Config config = new Config();
    config.useSingleServer()
      .setAddress("redis://" + host + ":" + port)
      .setPassword(password)
      .setDatabase(database)
      .setTimeout(timeout);
    //添加主从配置
//  config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});
    
    return Redisson.create(config);
  }
}
