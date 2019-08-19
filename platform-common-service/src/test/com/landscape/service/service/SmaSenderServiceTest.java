package com.landscape.service.service;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.landscape.service.entity.ShortMessageInfo;
import com.landscape.service.sms.core.SendSmsTemplate;
import org.junit.jupiter.api.Test;

/**
 * @author : eddie
 * @date : 2019-08-19
 */
class SmaSenderServiceTest {



    public static void main(String[] args) {


    }
    @Test
    void sendSMSCaptcha() {
        SendSmsTemplate sendMessage = new SendSmsTemplate();
        ShortMessageInfo shortMessageInfo = new ShortMessageInfo("123456");
        sendMessage.sendSms("18640026006", JSON.toJSONString(shortMessageInfo));
    }

    @Test
    void checkSmsCaptcha() {
    }
}