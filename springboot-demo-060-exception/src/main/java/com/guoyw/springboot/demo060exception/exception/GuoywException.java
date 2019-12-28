package com.guoyw.springboot.demo060exception.exception;

import lombok.Data;

/**
 * @program: springBoot-demo
 * @description:
 * @author: guoyw
 * @create: 2019-12-26 21:22
 **/
@Data
public class GuoywException extends RuntimeException {

  private String codeName;
  private String[] params;

  public GuoywException(String codeName) {
    super(codeName);
    this.codeName=codeName;
    this.params = new String[]{};
  }

  public GuoywException(String codeName, String[] params) {
    super(codeName);
    this.codeName=codeName;
    this.params = params;
  }


  public GuoywException(String codeName, String[] params, Throwable cause) {
    super(codeName, cause);
    this.codeName=codeName;
    this.params = params;
  }

  public String[] getParams() {
    return params;
  }

}
