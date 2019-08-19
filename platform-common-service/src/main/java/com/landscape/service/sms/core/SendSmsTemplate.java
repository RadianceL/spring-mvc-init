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
public class SendSmsTemplate {

    /**
     * 发送成功返回标记
     */
    public static final String SUCCESS_CODE = "OK";

    /**
     * 区域标识
     */
    private static final String REGION_ID = "cn-hangzhou";

    /**
     * access key
     */
    private static final String ACCESS_KEY = "LTAInSd4FnV6yuov";

    /**
     * 应用名称
     */
    private static final String SIGN_NAME = "landscape";

    /**
     * 模版编码
     */
    private static final String TEMPLATE_CODE = "SMS_172602233";

    /**
     * access secret
     */
    private static final String ACCESS_SECRET = "le8ruQ1UYu37D3aLxeFU0zO9u99Zm0";

    /**
     * 阿里请求客户端
     */
    private static IAcsClient client;

    public SendSmsTemplate(){
        DefaultProfile profile = DefaultProfile.getProfile(REGION_ID, ACCESS_KEY, ACCESS_SECRET);
        client = new DefaultAcsClient(profile);
    }

    public CommonResponse sendSms(String phoneNumber, String templateParameter){
        CommonRequest request = new CommonRequest();
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

        request.putQueryParameter("RegionId", REGION_ID);
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", SIGN_NAME);
        request.putQueryParameter("TemplateCode", TEMPLATE_CODE);
        request.putQueryParameter("TemplateParam", templateParameter);
        request.putQueryParameter("SmsUpExtendCode", "000");
        try {
            return client.getCommonResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean querySmsForResult(){

        return false;
    }

}
