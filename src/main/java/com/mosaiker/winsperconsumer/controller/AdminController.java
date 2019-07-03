package com.mosaiker.winsperconsumer.controller;

import com.alibaba.fastjson.JSONObject;

import com.mosaiker.winsperconsumer.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

  @Autowired
  private AdminService adminService;


  @RequestMapping(value = "/showAll", method = RequestMethod.GET)
  public ResponseEntity<JSONObject> findByPage() {
    JSONObject result = adminService.findAllUser();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @RequestMapping(value = "/manage", method = RequestMethod.PUT)
  public ResponseEntity<JSONObject> changeStatus(
      @RequestBody JSONObject param) {
    JSONObject result = adminService.changeStatus(param);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
