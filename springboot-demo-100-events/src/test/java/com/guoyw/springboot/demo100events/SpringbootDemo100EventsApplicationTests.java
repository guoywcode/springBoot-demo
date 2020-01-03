package com.guoyw.springboot.demo100events;

import com.google.common.eventbus.EventBus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringbootDemo100EventsApplicationTests{
  
  @Test
  public void contextLoads(){
  }
  
  @Test
  public void eventBus(){
    // 定义一个EventBus对象，因为我这里是测试，才这样写的。实际你应该定义一个单例获取其他的方式
    EventBus eventBus = new EventBus("test");
    // 注册监听者
    eventBus.register(new OrderEventListener());
    // 发布消息
    eventBus.post(new OrderMessage());
    
  }
  
}
