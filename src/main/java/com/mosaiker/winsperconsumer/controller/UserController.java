package com.mosaiker.winsperconsumer.controller;

import com.alibaba.fastjson.JSONObject;

import com.mosaiker.winsperconsumer.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/sendCode", method = RequestMethod.POST)
  public ResponseEntity<JSONObject> sendCode(@RequestBody JSONObject request){
    JSONObject result=userService.sendCode(request);
    return new ResponseEntity<>(result,HttpStatus.OK);
  }

  @RequestMapping(value = "/signup", method = RequestMethod.POST)
  public ResponseEntity<JSONObject> signup(@RequestBody JSONObject request){
    JSONObject result=userService.signup(request);
    return new ResponseEntity<>(result,HttpStatus.OK);
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<JSONObject> login(@RequestBody JSONObject request){
    JSONObject result=userService.login(request);
    return new ResponseEntity<>(result,HttpStatus.OK);
  }

  @RequestMapping(value = "/updateInfo", method = RequestMethod.PUT)
  public ResponseEntity<JSONObject>  updateInfo(@RequestHeader("Authorization") String token,@RequestBody JSONObject request){
    request.put("token", token);
    JSONObject result=userService.updateInfo(request);
    return new ResponseEntity<>(result,HttpStatus.OK);
  }


}
