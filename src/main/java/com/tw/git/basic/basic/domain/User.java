package com.tw.git.basic.basic.domain;

import com.tw.git.basic.basic.common.ExceptionMessageConstant;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User {

  private int id;

  @NotBlank(message = ExceptionMessageConstant.USERNAME_NOT_NULL)
  @Pattern(regexp = "^[0-9a-zA-Z_]{3,10}$", message = ExceptionMessageConstant.USERNAME_ILLEGAL)
  private String username;

  @NotEmpty(message = ExceptionMessageConstant.PASSWORD_NOT_NULL)
  @Size(min = 5, max = 12, message = ExceptionMessageConstant.PASSWORD_ILLEGAL)
  private String password;

  @Email(message = ExceptionMessageConstant.EMAIL_ILLEGAL)
  private String email;

}
