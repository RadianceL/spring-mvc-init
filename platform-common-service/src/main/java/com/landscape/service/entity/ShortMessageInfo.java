package com.landscape.service.entity;

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
     * 验证码
     */
    private String code;


}
