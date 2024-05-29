package com.polaris.apiinterface.controller;


import java.util.Arrays;


import cn.hutool.json.JSONUtil;
import com.polaris.papiclientsdk.basicapi.model.request.GetNameByPost2Request;
import com.polaris.papiclientsdk.basicapi.model.response.GetNameByPostResponse;

import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @data 2024-03-07 21:33
 * @version 1.0
 * ClassName NameController
 * Package com.polaris.apiinterface.controller
 * Description
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/a")
    public String getNameByGet(@RequestParam String name){
        return "Hello!We've get your name: "+ name;
    }
    @PostMapping("/b/{name}")
    public String getNameByPost1(@PathVariable String name){
        return "Hello!We've post your name: "+name;
    }
    @PostMapping("/c")
    public GetNameByPostResponse getNameByPost2(@RequestBody GetNameByPost2Request request){
        return JSONUtil.toBean(JSONUtil.toJsonStr(request), GetNameByPostResponse.class);
    }

}
