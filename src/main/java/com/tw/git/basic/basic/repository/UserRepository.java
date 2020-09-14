package com.tw.git.basic.basic.repository;

import com.tw.git.basic.basic.common.MockDataBase;
import com.tw.git.basic.basic.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  public void save(User user) {
    MockDataBase.USER_LIST.add(user);
    MockDataBase.USER_MAP.put(user.getUsername(), user);
  }

  public User findOne(String username) {
    return MockDataBase.USER_MAP.get(username);
  }

  public boolean isRepeat(String userName) {
    if (MockDataBase.USER_MAP.get(userName) != null) {
      return true;
    }
    return false;
  }

  public int countUser() {
    return MockDataBase.USER_LIST.size();
  }

}
