package com.tw.git.basic.basic.exception;

public class ParamIllegalException extends RuntimeException {

  private final String errorMessage;

  public ParamIllegalException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String getMessage() {
    return errorMessage;
  }
}
