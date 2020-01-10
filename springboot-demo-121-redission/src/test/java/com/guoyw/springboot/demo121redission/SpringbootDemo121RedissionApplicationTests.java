package com.guoyw.springboot.demo121redission;

import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class SpringbootDemo121RedissionApplicationTests{

  @Resource
  private RedissonClient redissonClient;
  
  @Test
  public void RedissionTest(){
    RBucket<String> key = redissonClient.getBucket("newday");
    key.set("新的数据");
    System.out.println("获取到新存入的数据："+key.get());
    // 获取字符串格式的数据
    RBucket<String> keyObj = redissonClient.getBucket("myname");
    String s = keyObj.get();
    System.out.println("获取到昨天存入的数据："+s);
  }
  
}
