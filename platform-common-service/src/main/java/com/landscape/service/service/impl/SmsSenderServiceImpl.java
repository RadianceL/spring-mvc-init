package com.landscape.service.service.impl;

import com.landscape.service.service.SmaSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    public boolean sendSMSCaptcha(String phoneNumber, String captchaType) {

        return false;
    }

    public boolean checkSmsCaptcha(String phoneNumber, String captchaCode, String captchaType) {
        return false;
    }
}
