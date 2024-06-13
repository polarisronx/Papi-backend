package com.polaris.papiclientsdk.basicapi.model.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.polaris.papiclientsdk.basicapi.model.response.LstmPredictResponse;
import com.polaris.papiclientsdk.common.enums.RequestMethodEnum;
import com.polaris.papiclientsdk.common.model.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author polaris
 * @version 1.0
 * ClassName LstmPredictRequest
 * Package com.polaris.apiinterface.model
 * Description
 * @create 2024-06-12 19:24
 */
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = { "file","fd","inputStream"})
@Data
public class LstmPredictRequest extends AbstractRequest<LstmPredictResponse> {
    private int timeStep;
    private double ratio;
    private int epoch;
    private int batchSize;
    public LstmPredictRequest(){

    }
    public LstmPredictRequest(int timeStep,double ratio,int epoch,int batchSize){
        this.timeStep=timeStep;
        this.ratio=ratio;
        this.epoch=epoch;
        this.batchSize=batchSize;
    }
    @Override
    public void setCustomField (Map<String, Object> params){
        for (Map.Entry<String, Object> entry : params.entrySet()){
            if (entry.getKey().equals("timeStep")) {
                this.timeStep = (Integer)entry.getValue();
            } else if (entry.getKey().equals("ratio")) {
                this.ratio = (Double)entry.getValue();
            } else if (entry.getKey().equals("epoch")) {
                this.epoch = (Integer)entry.getValue();
            } else if (entry.getKey().equals("batchSize")) {
                this.batchSize = (Integer)entry.getValue();
            }
        }
    }

    @Override
    public String getMethod (){
        return RequestMethodEnum.POST.getMethod();
    }

    @Override
    public String getPath (){
        return "/api/v2/dl/lstm";
    }

    @Override
    public Class<LstmPredictResponse> getResponseClass (){
        return LstmPredictResponse.class;
    }

    @Override
    public void toMap (HashMap<String, String> params, String prefix){
        this.setParamSimple(params, prefix + "timeStep", this.timeStep);
        this.setParamSimple(params, prefix + "ratio", this.ratio);
        this.setParamSimple(params, prefix + "epoch", this.epoch);
        this.setParamSimple(params, prefix + "batchSize", this.batchSize);
    }
}
