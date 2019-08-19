package com.landscape.im.netty.core;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author : eddie
 * @date : 2019-08-17
 */
public class GroupChannelManager {

    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 记录当前用户与通道Map
     */
    private static ConcurrentMap<String, String> userChannelMap = new ConcurrentHashMap<>(16);

    /**
     * 获取所有的通道
     * @return
     */
    public static ChannelGroup getAllChannel(){

        return  channels;
    }
}
