package com.polaris.apiinterface.service;

import com.polaris.papiclientsdk.basicapi.model.request.LstmPredictRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @author polaris
 * @version 1.0
 * ClassName LstmPredictor
 * Package com.polaris.apiinterface.service
 * Description
 * @create 2024-06-12 16:35
 */
@Service
@FeignClient(value = "service-django",url = "http://127.0.0.1:8000/")
public interface LstmPredictor {
    @PostMapping(value = "/user/lstm_predict", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
    HashMap<String,Object> lstmPredictExcel(@RequestParam String lstmPredictRequest, @RequestPart(value = "xlsx") MultipartFile excelData);
    @PostMapping(value = "/user/lstm_predict", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
    HashMap<String,Object> lstmPredictCsv(@RequestParam String lstmPredictRequest,@RequestPart(value = "csvData") MultipartFile csvData);
}
