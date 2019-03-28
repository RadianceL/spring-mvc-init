package com.example.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author eddie
 * @createTime 2019-03-17
 * @description 测试定时任务
 */
@Component
public class TestJob001 {

    @Scheduled(cron = "0/1 * * * * ? ")
    private void test(){

    }
}
