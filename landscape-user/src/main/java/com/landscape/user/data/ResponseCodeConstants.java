package com.landscape.user.data;

/**
 * 返回编码常量
 * <p>
 * 2019-08-10
 *
 * @author eddie
 */
public class ResponseCodeConstants {

    /*
        标准定义：
            0000 系统成功
            1--- 业务异常 该类型异常为允许出现的 例如账户余额不足
            2--- 参数异常 该类型异常为请求参数不全 不能完成后续逻辑
            3--- 接口异常 第三方接口异常
            4--- 通用异常 我方程序出现未在service处理的，抛出到全局处理器的异常，以及代码错误
            9--- 用户异常 登录、注册、认证等
     */

    /**
     * 成功
     */
    public static final String STATE_OK_0000 = "0000";

    /**
     * 参数缺失 提示缺失字段
     */
    public static final String INVALID_FIELD_PARAM_2001 = "2001";

    /**
     * 参数缺失 不提示缺失字段
     */
    public static final String INVALID_FIELD_PARAM_2002 = "2002";

    /**
     * 无效的TOKEN信息
     */
    public static final String INVALID_TOKEN_CODE_9999 = "9999";

    /**
     * 错误的用户名或密码
     */
    public static final String INVALID_USERNAME_PASSWORD_9001 = "9001";
}
