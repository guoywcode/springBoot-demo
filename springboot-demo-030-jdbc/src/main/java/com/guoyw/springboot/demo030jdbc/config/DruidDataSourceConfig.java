package com.guoyw.springboot.demo030jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: guoyw
 * create: 2019-12-19 14:51
 **/
@Configuration
@EnableConfigurationProperties(value = DruidDataSourceProperties.class)
public class DruidDataSourceConfig{
  
  @Autowired
  private DruidDataSourceProperties properties;
  
  @Bean
  public DataSource dataSource() throws SQLException{
    System.out.println(properties);
    DruidDataSource druidDataSource = new DruidDataSource();
    druidDataSource.setUsername(properties.getUsername());
    druidDataSource.setPassword(properties.getPassword());
    druidDataSource.setUrl(properties.getJdbcUrl());
    druidDataSource.setDriverClassName(properties.getDriverClassName());
    druidDataSource.setInitialSize(properties.getInitialSize());
    druidDataSource.setMinIdle(properties.getMinIdle());
    druidDataSource.setMaxActive(properties.getMaxActive());
    druidDataSource.setMaxWait(properties.getMaxWait());
    druidDataSource.setFilters(properties.getFilters());
    properties.setPoolPreparedStatements(properties.isPoolPreparedStatements());
    return druidDataSource;
  }
  
  /**
   * 配置druid管理后台的servlet
   * @return
   */
  @Bean
  public ServletRegistrationBean statViewSerlvet() {
    ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
    Map<String,Object> initParameters = new HashMap<>();
    initParameters.put("loginUsername","admin");
    initParameters.put("loginPassword","123456");
    bean.setInitParameters(initParameters);
    return bean;
  }
  
  @Bean
  public FilterRegistrationBean filterRegistrationBean() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
    filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
    
    Map<String,Object> initParams = new HashMap<>();
    initParams.put("exclusions","*.js,*.css,/druid/*");
    filterRegistrationBean.setInitParameters(initParams);
    return  filterRegistrationBean;
  }
}
