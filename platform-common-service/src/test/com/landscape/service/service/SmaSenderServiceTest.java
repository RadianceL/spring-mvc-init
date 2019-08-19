package com.landscape.service.service;

import com.aliyuncs.CommonRequest;
import com.landscape.service.sms.core.AbstractSendSmsTemplate;
import org.junit.jupiter.api.Test;

/**
 * @author : eddie
 * @date : 2019-08-19
 */
class SmaSenderServiceTest {



    public static void main(String[] args) {
        boolean sendMessage = new AbstractSendSmsTemplate() {
            @Override
            public void valueOfSmsRequest(CommonRequest request) {
                request.putQueryParameter("RegionId", "cn-hangzhou");
                request.putQueryParameter("PhoneNumbers", "18640026006");
                request.putQueryParameter("SignName", "ce");
                request.putQueryParameter("TemplateCode", "0001");
            }
        }.sendSms();


    }
    @Test
    void sendSMSCaptcha() {

    }

    @Test
    void checkSmsCaptcha() {
    }
}