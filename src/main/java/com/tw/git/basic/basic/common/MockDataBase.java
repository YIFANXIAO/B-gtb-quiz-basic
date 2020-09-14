package com.tw.git.basic.basic.common;


import com.tw.git.basic.basic.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDataBase {

  private MockDataBase(){};

  public static final List<User> USER_LIST = new ArrayList<>();

  public static final Map<String, User> USER_MAP = new HashMap<>();

}
