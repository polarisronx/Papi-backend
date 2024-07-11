package com.polaris.apiinterface.util;

import com.polaris.papiclientsdk.common.utils.http.HttpConnection;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author polaris
 * @version 1.0
 * ClassName HttpUtil
 * Package com.polaris.apiinterface.util
 * Description
 * @create 2024-07-09 20:49
 */
public class HttpUtil {

    public static String get(String uri){
        try {
            Request httpRequest = new Request.Builder().url(uri).get().build();
            HttpConnection httpConnection = new HttpConnection(60000, 60000, 60000);
            Response httpResponse = httpConnection.doRequest(httpRequest);
            if (httpResponse.code() == 200)return httpResponse.body().string();
            else return "error";
        }catch (Exception e){
            return "error";
        }

    }
}
