package com.mosaiker.winsperconsumer.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceHystric implements AdminService {
    @Override
    public JSONObject findAllUser() {
        JSONObject result = new JSONObject();
        result.put("message", "服务器故障，请稍后重试");
        return result;
    }

    @Override
    public JSONObject changeStatus(JSONObject param) {
        JSONObject result = new JSONObject();
        result.put("message", "服务器故障，请稍后重试");
        return result;
    }
}
