package com.polaris.apiinterface.controller.v2;

import cn.hutool.json.JSONUtil;
import com.polaris.apiinterface.service.LstmPredictor;
import com.polaris.common.exception.ErrorCode;
import com.polaris.papiclientsdk.basicapi.model.request.LstmPredictRequest;
import com.polaris.papiclientsdk.basicapi.model.response.LstmPredictResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;

import static com.polaris.common.exception.ThrowUtils.throwIf;

/**
 * @author polaris
 * @version 1.0
 * ClassName LstmPredictController
 * Package com.polaris.apiinterface.controller.v2
 * Description
 * @create 2024-06-12 20:06
 */
@RestController
@RequestMapping("/v2/dl")
public class DeepLearningController {
    enum FileType {
        EXCEL("xlsx"),
        CSV("csv");
        private final String value;
        FileType(String value) {
           this.value = value;
        }
    }

    @Resource
    private LstmPredictor lstmPredictor;

    @PostMapping("/lstm")
    public LstmPredictResponse lstmPredict(@RequestPart(value = "excelData",required = false) MultipartFile excelData,@RequestPart(value = "csvData",required = false) MultipartFile csvData,LstmPredictRequest lstmPredictRequest){
        throwIf(excelData==null && csvData==null, ErrorCode.PARAMS_ERROR,"文件不能为空");
        HashMap<String, Object> map = excelData != null ? lstmPredictor.lstmPredictExcel(JSONUtil.toJsonStr(lstmPredictRequest), excelData)
                : lstmPredictor.lstmPredictCsv(JSONUtil.toJsonStr(lstmPredictRequest), csvData);
        return new LstmPredictResponse((String)map.get("data"));
    }


}
