package com.guoyw.springboot.demo120redis;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionStatus;

import java.util.HashMap;

@SpringBootTest
class SpringbootDemo120RedisApplicationTests{

  @Autowired
  private MyRedisDao dao;
  
  @Test
  void contextLoads(){
  
    dao.getTransactionManager().doTransaction((TransactionStatus s) -> {
      //插入数据库
      int insert = dao.insert(tbCmChannelcustomerModel);
      // 加入缓存
      HashMap<String, Object> map = new HashMap<>();
      map.put(tbCmChannelcustomerModel.getFuniqueid().toString()
        , JSON.toJSONString(tbCmChannelcustomerModel));
      redisDao.setMap(map);
      // 发布redis通知消息
      redisService.setMessage(tbCmChannelcustomerModel.getFuniqueid());
    });
  }

}
