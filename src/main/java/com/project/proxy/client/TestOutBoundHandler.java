package com.project.proxy.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @author cst
 * @date 2023/3/4 1:08
 */
public class TestOutBoundHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("测试outBoundHandler");
        ctx.writeAndFlush(msg, promise);
    }

}
