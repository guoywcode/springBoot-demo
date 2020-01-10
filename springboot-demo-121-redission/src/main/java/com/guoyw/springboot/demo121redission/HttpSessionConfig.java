package com.guoyw.springboot.demo121redission;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author: guoyw
 * create: 2020-01-10 10:40
 **/
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60*30)
public class HttpSessionConfig{
}
