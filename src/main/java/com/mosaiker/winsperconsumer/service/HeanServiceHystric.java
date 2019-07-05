package com.mosaiker.winsperconsumer.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class HeanServiceHystric implements HeanService {
    @Override
    public JSONObject findAllByUId(JSONObject param) {
        JSONObject result = new JSONObject();
        result.put("message", "服务器故障，请稍后重试");
        return result;
    }

    @Override
    public JSONObject findAll() {
        JSONObject result = new JSONObject();
        result.put("message", "服务器故障，请稍后重试");
        return result;
    }

    @Override
    public JSONObject deleteHean(JSONObject param) {
        JSONObject result = new JSONObject();
        result.put("message", "服务器故障，请稍后重试");
        return result;
    }

    @Override
    public JSONObject uploadHean(MultipartFile[] files, Long uId, String text, String location) {
        JSONObject result = new JSONObject();
        result.put("message", "服务器故障，请稍后重试");
        return result;
    }

    @Override
    public byte[] getPicture(String pId) {
        return null;
    }
}
