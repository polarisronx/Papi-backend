package com.polaris.apiinterface.controller.v2;

import cn.hutool.json.JSONUtil;
import com.polaris.apiinterface.service.LstmPredictor;
import com.polaris.common.exception.ErrorCode;
import com.polaris.papiclientsdk.basicapi.model.request.LstmPredictRequest;
import com.polaris.papiclientsdk.basicapi.model.response.LstmPredictResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
@Slf4j
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
    public LstmPredictResponse lstmPredict(@RequestParam(value = "xlsx",required = false) MultipartFile xlsxFile,
                                           @RequestParam(value = "csv",required = false) MultipartFile csvFile,
                                           @RequestParam(required = false) String lstmPredictRequest,HttpServletRequest request){
        throwIf(xlsxFile==null&&csvFile==null, ErrorCode.PARAMS_ERROR,"文件不能为空");
        HashMap<String, Object> map = xlsxFile != null ? lstmPredictor.lstmPredictExcel(lstmPredictRequest, xlsxFile)
                : lstmPredictor.lstmPredictCsv(lstmPredictRequest, csvFile);
        return new LstmPredictResponse((String)map.get("data"));
    }


}
