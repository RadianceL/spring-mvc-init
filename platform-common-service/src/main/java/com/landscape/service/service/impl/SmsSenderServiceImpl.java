package com.landscape.service.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonResponse;
import com.landscape.service.entity.ShortMessageInfo;
import com.landscape.service.service.SmaSenderService;
import com.landscape.service.sms.core.SendSmsTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 短信发送服务
 *
 * @author : eddie
 * @date : 2019-08-19
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SmsSenderServiceImpl implements SmaSenderService {

    private final SendSmsTemplate sendSmsTemplate = new SendSmsTemplate();

    @Override
    public boolean sendSmsCaptcha(String phoneNumber, String captchaType) {
        ShortMessageInfo shortMessageInfo = new ShortMessageInfo("");
        CommonResponse response = sendSmsTemplate.sendSms(phoneNumber, JSON.toJSONString(shortMessageInfo));
        if(!Objects.isNull(response) && !Objects.isNull(response.getData())) {
            JSONObject responseJson = JSON.parseObject(response.getData());
            String code = responseJson.getString("Code");
            if (SendSmsTemplate.SUCCESS_CODE.equals(code)) {
                return true;
            } else {
                String errorMessage = responseJson.getString("Message");
                System.out.println(JSON.toJSONString(response));
            }
        }
        return false;
    }

    @Override
    public boolean checkSmsCaptcha(String phoneNumber, String captchaCode, String captchaType) {

        return false;
    }
}
