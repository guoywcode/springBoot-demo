package com.guoyw.springboot.dome115httpwechatlogin;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringbootDome115HttpWechatLoginApplicationTests{

  @Test
  public void contextLoads(){
    //url中的  appid 和  secret 开发者会给你  这相当于你小程序的ID和密码       js_code 也会给你  js_code是用微信开发者工具调用方法获得
    String  appid="";//你小程序Id
    String code="";//用微信开发者工具获取到的code
    String redirect_uri ="http://task.yioks.org";
    String state="1234545";
    String url="https://open.weixin.qq.com/connect/qrconnect?appid="+appid+"&redirect_uri="+redirect_uri+"&response_type=code&scope=snsapi_login&state="+state+"#wechat_redirect";
//  String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
    JSONObject jsonObj=HttpClientUtils.httpGet(url);
    System.out.println(jsonObj);
    //打印结果
  }

}
