package com.guoyw.springboot.demos090wagger.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: guoyw
 * create: 2019-12-24 16:11
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer{
  
  /**
   * 创建API应用
   * apiInfo() 增加API相关信息
   * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
   * 本例采用指定扫描的包路径来定义指定要建立API的目录。
   *
   * @return
   */
  @Bean
  public Docket createRestApi() {
  
    ParameterBuilder tokenPar = new ParameterBuilder();
    tokenPar.name("TOKEN").description("用户登录标识")
      .modelRef(new ModelRef("string")).parameterType("header")
      .required(false).build(); //header中的ticket参数非必填，传空也可以
  
    List<Parameter> pars = new ArrayList<Parameter>();
    pars.add(tokenPar.build()); //根据每个方法名也知道当前方法在设置什么参数
    
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      .select()
      .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//api接口包扫描路径
      .paths(PathSelectors.any()) //可以根据url路径设置哪些请求加入文档，忽略哪些请求
      .build()
      .globalOperationParameters(pars);
  }
  
  /**
   * 创建该API的基本信息（这些基本信息会展现在文档页面中）
   * 访问地址：http://项目实际地址/swagger-ui.html
   * @return
   */
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      .title("Store-managerment API")  //设置文档的标题
      .description("门店管理管理API") //设置文档的描述
      .termsOfServiceUrl("https://github.com/guoywcode/")
      .contact(new Contact("guoyw","","435945337@qq.com"))
      .version("1.0")
      .build();
  }
  
}
