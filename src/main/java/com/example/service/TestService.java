package com.example.service;

import com.example.entity.Response;

/**
 * @author eddie
 * @createTime 2019-03-17
 * @description 样例
 */
public interface TestService {

    /**
     * 测试方法
     * @param name 用户名
     * @return 标准返回
     */
    Response test(String name);
}
