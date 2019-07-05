package com.mosaiker.winsperconsumer.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystric implements UserService {
    @Override
    public JSONObject sendCode(JSONObject request) {
        JSONObject result = new JSONObject();
        result.put("message", "服务器故障，请稍后重试");
        return result;
    }

    @Override
    public JSONObject signup(JSONObject request) {
        JSONObject result = new JSONObject();
        result.put("message", "服务器故障，请稍后重试");
        return result;
    }

    @Override
    public JSONObject login(JSONObject request) {
        JSONObject result = new JSONObject();
        result.put("message", "服务器故障，请稍后重试");
        return result;
    }

    @Override
    public JSONObject updateInfo(JSONObject request) {
        JSONObject result = new JSONObject();
        result.put("message", "服务器故障，请稍后重试");
        return result;
    }


}
