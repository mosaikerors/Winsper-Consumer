package com.mosaiker.winsperconsumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.winsperconsumer.service.HeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

  @RequestMapping(value = "/byUId", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<JSONObject> searchByUser(@RequestBody JSONObject param) {
    JSONObject heanList = heanService.findAllByUId(param);
    return new ResponseEntity<>(heanList, HttpStatus.OK);
  }


  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public ResponseEntity<JSONObject> deleteByHId(@RequestBody JSONObject param) {
    JSONObject result = heanService.deleteHean(param);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<JSONObject> uploadPicture(
      @RequestParam(value = "pictures") MultipartFile[] files,
      @RequestParam(value = "uId") Long uId, @RequestParam(value = "text") String text,
      @RequestParam(value = "location") String location) {
    JSONObject result = heanService.uploadHean(files, uId, text, location);
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
