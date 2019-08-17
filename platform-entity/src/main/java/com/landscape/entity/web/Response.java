package com.landscape.entity.web;

import com.landscape.entity.configuration.ResponseCodeConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;


import java.util.*;

/**
 * 通用返回
 * <p>
 * 2019-08-10
 *
 * @author eddie
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Object value;

    /**
     * 无效的登录信息
     */
    public static final Response INVALID_TOKEN = new Response(ResponseCodeConstants.INVALID_TOKEN_CODE_9999, "无效的登录信息");

    /**
     * 错误的用户名或密码
     */
    public static final Response INVALID_USERNAME_PASSWORD = new Response(ResponseCodeConstants.INVALID_USERNAME_PASSWORD_9001, "错误的用户名或密码");

    /**
     * 参数缺失 不提示缺失字段
     */
    public static final Response INVALID_MISSING_FIELD_PARAMETER = new Response(ResponseCodeConstants.INVALID_FIELD_PARAM_2002, "缺少必要参数");


    private Response(String resultCode, String systemMessage) {
        this.resultCode = resultCode;
        this.systemMessage = systemMessage;
    }

    public static Response assemblyNotNullFieldResponseInstance(List<String> notNullFields){
        return new Response(
                ResponseCodeConstants.INVALID_FIELD_PARAM_2001,
                "缺少必要字段[".concat(notNullFields.toString()).concat("]")
        );
    }

    public static Response newPagingResponseInstance(List<Map<String, Object>> data, Page pagingMap){
        Response response = new Response();
        response.setResultCode(ResponseCodeConstants.STATE_OK_0000);
        response.setSystemMessage("操作成功");
        Map<String, Object> paging = new HashMap<>(2);
        paging.put("page", pagingMap);
        if (Objects.isNull(data)){
            paging.put("list", new ArrayList<Map<String, Object>>(0));
        }else {
            paging.put("list", data);
        }
        response.setValue(paging);
        return response;
    }

    public static Response newDataResponseInstance(List<?> data){
        Response response = new Response();
        response.setResultCode(ResponseCodeConstants.STATE_OK_0000);
        response.setSystemMessage("操作成功");
        if (Objects.isNull(data)){
            response.setValue(new ArrayList<Map<String, Object>>(0));
        }else {
            response.setValue(data);
        }
        return response;
    }

    public static Response assemblyCommonResultPagingDate(Map<String,Integer> pagingMap, List<?> dates){
        Response response = new Response();
        response.setResultCode(ResponseCodeConstants.STATE_OK_0000);
        response.setSystemMessage("操作成功");
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("page", pagingMap);
        if (Objects.isNull(dates)){
            resultMap.put("list", new ArrayList<>(0));
        }else {
            resultMap.put("list", dates);
        }
        response.setValue(resultMap);
        return response;
    }
}