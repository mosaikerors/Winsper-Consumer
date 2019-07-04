package com.mosaiker.winsperconsumer.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Primary  // 因为引入 fallback 类，出现两个同类 Bean，所以不加 @Primary 会导致 @Autowired 有红色波浪线（尽管不影响运行）
@FeignClient(value = "hean-service", path = "/hean")
//@RequestMapping(value = "/hean")  // 这里 url 公共的部分不能用 RequestMappnig，要用 @FeignClient 的 path 属性
public interface HeanService {

  @RequestMapping(value = "/byUId", method = RequestMethod.POST)
  @ResponseBody
  JSONObject findAllByUId(@RequestBody JSONObject param);

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  JSONObject findAll();

  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  @ResponseBody
  JSONObject deleteHean(@RequestBody JSONObject param);

  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  @ResponseBody
  JSONObject uploadHean(@RequestParam(value = "pictures") MultipartFile[] files,
      @RequestParam(value = "uId") Long uId, @RequestParam(value = "text") String text,
      @RequestParam(value = "location") String location);

  @RequestMapping(value = "/pictures/get/{pId}", method = RequestMethod.GET, produces = {
      MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
  @ResponseBody
  byte[] getPicture(@PathVariable String pId);

}
