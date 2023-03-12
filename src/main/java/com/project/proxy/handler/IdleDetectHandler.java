package com.project.proxy.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author hanxin
 * @date 2023/3/12 18:37
 */
public class IdleDetectHandler extends IdleStateHandler {

    private static final int READ_IDLE_TIME = 60;

    public IdleDetectHandler() {
        super(READ_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        System.out.println(READ_IDLE_TIME + "秒未检测到读请求，连接关闭");
        ctx.channel().close();
//        ctx.fireUserEventTriggered(evt);
    }

}
