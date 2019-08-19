package com.landscape.service.sms.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Objects;

/**
 * 发送短信模版工具类
 *
 * @author : eddie
 * @date : 2019-08-19
 */
public abstract class AbstractSendSmsTemplate {

    private static final String SUCCESS_CODE = "OK";

    private static IAcsClient client;

    protected AbstractSendSmsTemplate(){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAInSd4FnV6yuov", "le8ruQ1UYu37D3aLxeFU0zO9u99Zm0");
        client = new DefaultAcsClient(profile);
    }

    public boolean sendSms(){
        CommonRequest request = new CommonRequest();
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        valueOfSmsRequest(request);


        try {
            CommonResponse response = client.getCommonResponse(request);
            if(!Objects.isNull(response) && !Objects.isNull(response.getData())) {
                JSONObject responseJson = JSON.parseObject(response.getData());
                String code = responseJson.getString("Code");
                if(SUCCESS_CODE.equals(code)){
                    return true;
                }else {
                    String errorMessage = responseJson.getString("Message");
                    throw new ClientException(errorMessage);
                }
            }else {
                return false;
            }

        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean querySmsForResult(){

        return false;
    }

    /**
     * 为CommonRequest填充内容
     * @param request
     */
    public abstract void valueOfSmsRequest(CommonRequest request);
}
