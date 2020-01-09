package com.guoyw.springboot.demo110http;

import org.apache.http.conn.HttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时回收没有使用的链接 交还给连接池
 *
 * @author: guoyw
 * create: 2020-01-09 10:58
 **/
@Component
public class IdleConnectionEvictor extends Thread{
  
  @Autowired
  private HttpClientConnectionManager httpClientConnectionManager;
  private volatile boolean shutdown;
  
  public IdleConnectionEvictor(){
    super();
    super.start();
  }
  
  @Override
  public void run(){
    try{
      while(!shutdown){
        synchronized(this){
          wait(5000);
// 关闭失效的连接
          httpClientConnectionManager.closeExpiredConnections();
        }
      }
    }catch(InterruptedException ex){
// 结束
    }
  }
  
  //关闭清理无效连接的线程
  public void shutdown(){
    shutdown = true;
    synchronized(this){
      notifyAll();
    }
  }
  
}
