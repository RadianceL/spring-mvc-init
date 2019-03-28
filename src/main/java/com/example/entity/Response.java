package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author eddie
 * @createTime 2019-03-12
 * @description 系统通用返回值
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    /**
     * 标准返回代码
     */
    private String resultCode;

    /**
     * 系统信息
     */
    private String systemMessage;

    /**
     * 业务参数返回
     */
    private String value;

    public static final Response INVALID_PARAM = new Response("100", "失败", "无效的请求参数");

    public Response(Exception e) {
        this.resultCode = "100";
        this.systemMessage = "发生异常";
        this.value = e.getMessage();
    }
}
