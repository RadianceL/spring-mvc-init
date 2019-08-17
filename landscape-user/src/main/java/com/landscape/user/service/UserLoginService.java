package com.landscape.user.service;

import com.example.entity.web.Response;

/**
 * 用户登录服务接口
 * <p>
 * 2019-08-10
 *
 * @author eddie
 */
public interface UserLoginService {

    /**
     * 账号注册
     * @param userPhone   手机号
     * @param userAlias   用户别名
     * @param code        密码 || 短信验证码
     * @return
     */
    Response userAccountRegister(String userPhone, String userAlias, String code);

    /**
     * 手机号 + 密码登录
     * @param phoneNumber   手机号
     * @param password      密码
     * @return
     */
    Response userLoginByPassword(String phoneNumber, String password);

    /**
     * 手机号 + 验证码登录
     * @param phoneNumber   手机号
     * @param smsCode       验证码
     * @return
     */
    Response userLoginBySmsCode(String phoneNumber, String smsCode);
}
