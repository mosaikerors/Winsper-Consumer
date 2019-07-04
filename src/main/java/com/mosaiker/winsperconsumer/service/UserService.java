package com.mosaiker.winsperconsumer.service;

import com.alibaba.fastjson.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Primary  // 因为引入 fallback 类，出现两个同类 Bean，所以不加 @Primary 会导致 @Autowired 有红色波浪线（尽管不影响运行）
@FeignClient(value = "user-service", path = "/user")
//@RequestMapping(value = "/user")  // 这里 url 公共的部分不能用 RequestMappnig，要用 @FeignClient 的 path 属性
public interface UserService {

  @RequestMapping(value = "/sendCode", method = RequestMethod.POST)
  JSONObject sendCode(@RequestBody JSONObject request);

  @RequestMapping(value = "/signup", method = RequestMethod.POST)
  JSONObject signup(@RequestBody JSONObject request);

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  JSONObject login(@RequestBody JSONObject request);

  @RequestMapping(value = "/updateInfo", method = RequestMethod.PUT)
  JSONObject updateInfo(@RequestBody JSONObject request);
}
