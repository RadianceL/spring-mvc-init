package com.landscape.service.service;

/**
 * 短信发送服务
 *
 * @author : eddie
 * @date : 2019-08-19
 */
public interface SmaSenderService {

    /**
     * 发送短信验证码
     * @param phoneNumber       手机号码
     * @param captchaType       验证码类型
     * @return
     */
    boolean sendSmsCaptcha(String phoneNumber, String captchaType);

    /**
     * 校验短信验证码
     * @param phoneNumber       手机号码
     * @param captchaCode       验证码
     * @param captchaType       验证码类型
     * @return
     */
    boolean checkSmsCaptcha(String phoneNumber, String captchaCode, String captchaType);
}
