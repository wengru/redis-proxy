package com.project.proxy.client.handler;

import com.project.proxy.packet.request.HeartBeatRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author hanxin
 * @date 2023/3/12 18:56
 */
public class HeartBeatTimerHandler extends ChannelInboundHandlerAdapter {

    // 维持30秒的心跳
    private final int HEART_BEAT_INTERVAL = 30;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.heartBeatTask(ctx);
    }

    public void heartBeatTask(ChannelHandlerContext ctx) {
        ctx.executor().schedule(() -> {
            ctx.writeAndFlush(new HeartBeatRequestPacket());
            this.heartBeatTask(ctx);
        }, HEART_BEAT_INTERVAL, TimeUnit.SECONDS);
    }

}
