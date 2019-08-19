package com.landscape.im.netty.handler;

import com.alibaba.fastjson.JSON;
import com.landscape.im.netty.protocol.MessageProtocol;
import com.landscape.common.utils.thread.ExecutorPool;
import com.landscape.entity.configuration.ResponseCodeConstants;
import com.landscape.entity.web.Response;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import com.landscape.im.netty.core.GroupChannelManager;

import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @author : eddie
 * @date : 2019-08-17
 */
@Slf4j
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {

    private WebSocketServerHandshaker webSocketServerHandshaker;

    /**
     * 工作线程组
     */
    private static ExecutorPool workPool = ExecutorPool.getInstance(10, "M");


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        // 传统的HTTP接入
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(channelHandlerContext, (FullHttpRequest) msg);
        }
        // WebSocket接入
        else if (msg instanceof WebSocketFrame) {
            handleWebSocketFrame(channelHandlerContext, (WebSocketFrame) msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.debug("channelReadComplete:" + Thread.currentThread().getName());
        ctx.flush();
    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
        log.debug("handleHttpRequest:" + Thread.currentThread().getName());
        // 如果HTTP解码失败，返回HTTP异常
        if (!req.decoderResult().isSuccess() || (!"websocket".equals(req.headers().get("Upgrade")))) {
            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HTTP_1_1, BAD_REQUEST));
            return;
        }

        // 构造握手响应返回，本机测试
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory("ws://localhost:1949/222websocket/2222", null, false);
        webSocketServerHandshaker = wsFactory.newHandshaker(req);
        if (webSocketServerHandshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else {
            webSocketServerHandshaker.handshake(ctx.channel(), req);
        }
    }

    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        log.debug("handleWebSocketFrame:" + Thread.currentThread().getName());
        // 判断是否是关闭链路的指令
        if (frame instanceof CloseWebSocketFrame) {
            webSocketServerHandshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }
        // 判断是否是Ping消息
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        // 本例程仅支持文本消息，不支持二进制消息
        if (!(frame instanceof TextWebSocketFrame)) {
            throw new UnsupportedOperationException(
                    String.format("%s frame types not supported", frame.getClass().getName()));
        }

        // 返回应答消息
        String request = ((TextWebSocketFrame) frame).text();
        log.info(String.format("%s received %s", ctx.channel(), request));
        if (StringUtils.isNotEmpty(request)) {
            workPool.doWork(() -> {
                //消息处理
            });
        }

    }

    private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse res) {
        log.debug("sendHttpResponse:" + Thread.currentThread().getName());
        // 返回应答给客户端
        if (res.status().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.getStatus().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
            HttpUtil.setContentLength(res, res.content().readableBytes());
        }
        // 如果是非Keep-Alive，关闭连接
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if (!HttpUtil.isKeepAlive(req) || res.status().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("连接异常:exceptionCaught:", cause);
        //ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception { // (5)
        log.debug("建立连接channelActive:" + Thread.currentThread().getName());
        GroupChannelManager.getAllChannel().add(ctx.channel());
        Response response = new Response();
        response.setResultCode(ResponseCodeConstants.STATE_OK_0000);
        response.setSystemMessage(MessageProtocol.NEW_CONNECT);
        response.setValue(GroupChannelManager.getAllChannel().size());

        for (Channel channel : GroupChannelManager.getAllChannel()) {
            channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(response)));
        }
    }
//
//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        log.debug("关闭连接channelInactive:" + Thread.currentThread().getName());
//        GroupChannelManager.getAllChannel().remove(ctx.channel());
//        ctx.close();
//
//        Response response = new Response();
//        response.setResultCode(ResponseCodeConstants.STATE_OK_0000);
//        response.setSystemMessage(MessageProtocol.del_connect);
//        response.setValue(GroupChannelManager.getAllChannel().size());
//
//        for (Channel channel : GroupChannelManager.getAllChannel()) {
//            channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(response)));
//        }
//    }

}
