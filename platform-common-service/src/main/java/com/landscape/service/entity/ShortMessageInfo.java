package com.landscape.service.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短信信息
 *
 * @author : eddie
 * @date : 2019-08-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortMessageInfo {

    /**
     * 电话号码
     */
    @JSONField(name = "PhoneNumbers")
    private String phoneNumber;

    /**
     * 签名名称
     */
    @JSONField(name = "SignName")
    private String signName;

    /**
     * 模板CODE
     */
    @JSONField(name = "TemplateCode")
    private String templateCode;


}
