package com.mosaiker.winsperconsumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.winsperconsumer.service.HeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/hean")
public class HeanController {

  @Autowired
  private HeanService heanService;


  @RequestMapping(value = "/all", method = RequestMethod.POST)
  public ResponseEntity<JSONObject> searchAll() {
    JSONObject heanList = heanService.findAll();
    return new ResponseEntity<>(heanList, HttpStatus.OK);
  }

  @RequestMapping(value = "/{uId}", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<JSONObject> searchByUser(@PathVariable(value = "uId") Long uId) {
    JSONObject heanList = heanService.findAllByUId(uId);
    return new ResponseEntity<>(heanList, HttpStatus.OK);
  }


  @RequestMapping(value = "/delete/{hId}", method = RequestMethod.POST)
  public ResponseEntity<JSONObject> deleteByHId(@PathVariable(value = "hId") String hId) {
    JSONObject result = heanService.deleteHean(hId);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<JSONObject> uploadPicture(
      @RequestParam(value = "pictures") MultipartFile[] files,
      @RequestParam(value = "uId") Long uId, @RequestParam(value = "text") String text,
      @RequestParam(value = "location") String location) {
    JSONObject result = heanService.uploadPicture(files, uId, text, location);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @RequestMapping(value = "/pictures/get/{pId}", method = RequestMethod.GET, produces = {
      MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
  @ResponseBody
  public ResponseEntity<byte[]> getPicture(@PathVariable String pId) {
    byte[] result = heanService.getPicture(pId);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
