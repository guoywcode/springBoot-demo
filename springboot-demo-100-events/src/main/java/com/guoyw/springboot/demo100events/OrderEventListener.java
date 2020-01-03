package com.guoyw.springboot.demo100events;

import com.google.common.eventbus.Subscribe;

/**
 * 消息监听
 * @author: guoyw
 * create: 2020-01-02 16:06
 **/

public class OrderEventListener{
  
  /**
   * 如果发送了OrderMessage消息，会进入到该函数的处理
   * @param event 消息
   */
  @Subscribe
  public void dealWithEvent(OrderMessage event) {
    // TODO: 收到EventTest消息之后，做相应的处理
    System.out.println("我收到了您的命令，命令内容为：" + event.getOrderContent());
  }
}
