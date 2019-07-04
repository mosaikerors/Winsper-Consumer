package com.mosaiker.winsperconsumer.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.context.annotation.Primary;

import org.springframework.web.bind.annotation.*;


@Primary  // 因为引入 fallback 类，出现两个同类 Bean，所以不加 @Primary 会导致 @Autowired 有红色波浪线（尽管不影响运行）
@FeignClient(value = "admin-service", path = "/admin")
//@RequestMapping(value = "/admin")    //这里 url 公共的部分不能用 RequestMappnig，要用 @FeignClient 的 path 属性
public interface AdminService {

  @RequestMapping(value = "/userList", method = RequestMethod.GET)
  JSONObject findAllUser();


  @RequestMapping(value = "/manage", method = RequestMethod.PUT)
  JSONObject changeStatus(@RequestBody JSONObject param);

}
