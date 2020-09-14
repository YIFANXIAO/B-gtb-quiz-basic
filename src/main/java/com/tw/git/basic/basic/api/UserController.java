package com.tw.git.basic.basic.api;

import com.tw.git.basic.basic.domain.User;
import com.tw.git.basic.basic.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@CrossOrigin
@RequestMapping(value = "/v1")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(path = "/register")
  @ResponseStatus(HttpStatus.CREATED)
  public void registerUser(@RequestBody @Valid User user) {
    userService.registerUser(user);
  }

  @GetMapping(path = "/login")
  public User login(@RequestParam String username, @RequestParam String password) {
    return userService.login(username, password);
  }

}
