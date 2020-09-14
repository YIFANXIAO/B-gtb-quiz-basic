package com.tw.git.basic.basic.componet;

import com.tw.git.basic.basic.exception.ParamIllegalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.tw.git.basic.basic.exception.Error;
import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class UserExceptionHandle {

  @ExceptionHandler(value = {MethodArgumentNotValidException.class, ParamIllegalException.class})
  public ResponseEntity<Error> userValidExceptionHandle(Exception exception) {
    Error error = new Error();
    if (exception instanceof MethodArgumentNotValidException) {
      error.setErrorMessage(Objects.requireNonNull(((MethodArgumentNotValidException) exception).getBindingResult().getFieldError()).getDefaultMessage());
      log.error(Objects.requireNonNull(((MethodArgumentNotValidException) exception).getBindingResult().getFieldError()).getDefaultMessage());
    }else {
      error.setErrorMessage(exception.getMessage());
      log.error(exception.getMessage());
    }
    return ResponseEntity.badRequest().body(error);
  }

}
