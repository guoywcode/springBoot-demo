package com.guoyw.springboot.demo130httpclient;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SpringbootDemo130HttpClientApplicationTests{
  
  @Test
  public void contextLoads(){
  }
  
  
  @Test
  public void doGet() throws Exception{
  
    // 创建Httpclient对象,相当于打开了浏览器
    CloseableHttpClient httpclient = HttpClients.createDefault();
  
    // 创建HttpGet请求，相当于在浏览器输入地址
    HttpGet httpGet = new HttpGet("http://www.baidu.com/");
  
    CloseableHttpResponse response = null;
    try {
      // 执行请求，相当于敲完地址后按下回车。获取响应
      response = httpclient.execute(httpGet);
      // 判断返回状态是否为200
      if (response.getStatusLine().getStatusCode() == 200) {
        // 解析响应，获取数据
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(content);
      }
    } finally {
      if (response != null) {
        // 关闭资源
        response.close();
      }
      // 关闭浏览器
      httpclient.close();
    }
  }
  
  @Test
  public void doGETParam () throws Exception{
    // 创建Httpclient对象
    CloseableHttpClient httpclient = HttpClients.createDefault();
    // 创建URI对象，并且设置请求参数
    URI uri = new URIBuilder("http://www.baidu.com/s").setParameter("wd", "java").build();
    // 创建http GET请求
    HttpGet httpGet = new HttpGet(uri);
  
    CloseableHttpResponse response = null;
    try {
      // 执行请求
      response = httpclient.execute(httpGet);
      // 判断返回状态是否为200
      if (response.getStatusLine().getStatusCode() == 200) {
        // 解析响应数据
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(content);
      }
    } finally {
      if (response != null) {
        response.close();
      }
      httpclient.close();
    }
  }
  
  @Test
  public void doPOST  () throws Exception{
    // 创建Httpclient对象
    CloseableHttpClient httpclient = HttpClients.createDefault();
    // 创建http POST请求
    HttpPost httpPost = new HttpPost("http://www.oschina.net/");
    // 把自己伪装成浏览器。否则开源中国会拦截访问
    httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
  
    CloseableHttpResponse response = null;
    try {
      // 执行请求
      response = httpclient.execute(httpPost);
      // 判断返回状态是否为200
      if (response.getStatusLine().getStatusCode() == 200) {
        // 解析响应数据
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(content);
      }
    } finally {
      if (response != null) {
        response.close();
      }
      // 关闭浏览器
      httpclient.close();
    }
  }
  
  
  @Test
  public void doPOSTParam   () throws Exception{
    // 创建Httpclient对象
    CloseableHttpClient httpclient = HttpClients.createDefault();
    // 创建http POST请求，访问开源中国
    HttpPost httpPost = new HttpPost("http://www.oschina.net/search");
  
    // 根据开源中国的请求需要，设置post请求参数
    List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
    parameters.add(new BasicNameValuePair("scope", "project"));
    parameters.add(new BasicNameValuePair("q", "java"));
    parameters.add(new BasicNameValuePair("fromerr", "8bDnUWwC"));
    // 构造一个form表单式的实体
    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
    // 将请求实体设置到httpPost对象中
    httpPost.setEntity(formEntity);
  
    CloseableHttpResponse response = null;
    try {
      // 执行请求
      response = httpclient.execute(httpPost);
      // 判断返回状态是否为200
      if (response.getStatusLine().getStatusCode() == 200) {
        // 解析响应体
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(content);
      }
    } finally {
      if (response != null) {
        response.close();
      }
      // 关闭浏览器
      httpclient.close();
    }
  }
  
}
