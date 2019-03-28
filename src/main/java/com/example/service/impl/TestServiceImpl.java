package com.example.service.impl;

import com.example.entity.Response;
import com.example.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author eddie
 * @createTime 2019-03-17
 * @description 样例实现类
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public Response test(String name) {
        return null;
    }
}
