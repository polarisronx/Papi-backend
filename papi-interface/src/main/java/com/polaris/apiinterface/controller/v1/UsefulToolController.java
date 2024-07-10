package com.polaris.apiinterface.controller.v1;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.polaris.apiinterface.util.HttpUtil;

import com.polaris.common.exception.ErrorCode;

import com.polaris.papiclientsdk.basicapi.model.response.GetIpResponse;
import com.polaris.papiclientsdk.basicapi.model.response.RandomLoveStoryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author polaris
 * @version 1.0
 * ClassName UsefulToolController
 * Package com.polaris.apiinterface.controller.v1
 * Description
 * @create 2024-07-09 19:48
 */
@RestController
@RequestMapping("/v1/useful-tool")
public class UsefulToolController {
    @GetMapping("/loveStory")
    public RandomLoveStoryResponse randomLoveStory() {
        String loveStory = HttpUtil.get("https://api.vvhan.com/api/text/love");
        if(!loveStory.equals("error")){
            return new RandomLoveStoryResponse(loveStory);
        }else {
            RandomLoveStoryResponse randomLoveStoryResponse = new RandomLoveStoryResponse();
            randomLoveStoryResponse.setCode(ErrorCode.SYSTEM_ERROR.getCode());
            return randomLoveStoryResponse;
        }
    }

    @GetMapping("/ip")
    public GetIpResponse getIp() {
        String ipInfo = HttpUtil.get("https://api.vvhan.com/api/ipInfo");
        if(!ipInfo.equals("error")){
            JSONObject jsonObject = JSONUtil.parseObj(ipInfo);
            String ip = jsonObject.getStr("ip");
            JSONObject info = jsonObject.getJSONObject("info");
            String city = info.getStr("city");
            String country = info.getStr("country");
            String prov = info.getStr("prov");
            String isp = info.getStr("isp");
            return new GetIpResponse(ip,country,prov,city,isp);
        }else {
            GetIpResponse getIpResponse = new GetIpResponse();
            getIpResponse.setCode(ErrorCode.SYSTEM_ERROR.getCode());
            return getIpResponse;
        }

    }





}
