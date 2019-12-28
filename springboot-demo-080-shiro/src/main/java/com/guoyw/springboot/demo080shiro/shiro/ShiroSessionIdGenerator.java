package com.guoyw.springboot.demo080shiro.shiro;

import com.guoyw.springboot.demo080shiro.constant.RedisConstant;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;

/**
 * 自定义SessionId生成器
 * @author: guoyw
 * create: 2019-12-28 09:58
 **/

public class ShiroSessionIdGenerator implements SessionIdGenerator{
  
  // 实现SessionId生成
  @Override
  public Serializable generateId(Session session){
    Serializable sessionId = new JavaUuidSessionIdGenerator().generateId(session);
    return String.format(RedisConstant.REDIS_PREFIX_LOGIN, sessionId);
  }
}
