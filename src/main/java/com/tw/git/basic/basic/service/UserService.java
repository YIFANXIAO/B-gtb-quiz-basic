package com.tw.git.basic.basic.service;

import com.tw.git.basic.basic.common.ExceptionMessageConstant;
import com.tw.git.basic.basic.common.MockDataBase;
import com.tw.git.basic.basic.domain.User;
import com.tw.git.basic.basic.exception.ParamIllegalException;
import com.tw.git.basic.basic.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void registerUser(User user) {
    if (userRepository.isRepeat(user.getUsername())) {
      throw new ParamIllegalException(ExceptionMessageConstant.USERNAME_REPEAT);
    }
    user.setId(userRepository.countUser() + 1);
    userRepository.save(user);
  }

  public User login(String username, String password) {
    checkParamLegal(username, password);
    return userRepository.findOne(username);
  }

  private void checkParamLegal(String username, String password) {
    if (!Pattern.matches("^[0-9a-zA-Z_]{3,10}$", username)) {
      throw new ParamIllegalException(ExceptionMessageConstant.USERNAME_ILLEGAL);
    }
    if (!Pattern.matches("^.{5,12}$", password)) {
      throw new ParamIllegalException(ExceptionMessageConstant.PASSWORD_ILLEGAL);
    }
    if (MockDataBase.USER_MAP.get(username) == null || !password.equals(MockDataBase.USER_MAP.get(username).getPassword())) {
      throw new ParamIllegalException(ExceptionMessageConstant.USERNAME_PASSWORD_WRONG);
    }
  }
}
