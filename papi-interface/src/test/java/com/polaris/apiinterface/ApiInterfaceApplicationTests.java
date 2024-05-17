package com.polaris.apiinterface;


import com.polaris.papiclientsdk.basicapi.client.PapiClient;
import com.polaris.papiclientsdk.basicapi.model.request.GetNameByPost2Request;
import com.polaris.papiclientsdk.basicapi.model.response.GetNameByPostResponse;
import com.polaris.papiclientsdk.common.execption.PapiClientSDKException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {

    @Resource
    private PapiClient papiClient;
    @Test
    void contextLoads () throws PapiClientSDKException{
        // 测试 papiClient的getNameByGet方法，传入参数 polaris，并将返回的结果赋值给 result1 变量
//        String result1 = papiClient.getNameByGet("polaris");

        // 创建一个User对象
        GetNameByPost2Request request = new GetNameByPost2Request();
        request.setUsername("polarisronx");

        // 调用papiClient的getNameByPost方法，传入参数 user，并将返回的结果赋值给 result2 变量
        GetNameByPostResponse response = papiClient.getNameByPost2(request);

        // 打印 result1 和 result2
//        System.out.println(result1);
        System.out.println(response.getUsername());

    }

}
