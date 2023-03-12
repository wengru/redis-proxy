package com.project.proxy.handler;

import com.project.proxy.constant.Attributes;
import com.project.proxy.packet.response.LoginResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author hanxin
 * @date 2023/3/5 21:58
 */
@ChannelHandler.Sharable
public class AuthHandler extends ChannelInboundHandlerAdapter {

    public static final AuthHandler INSTANCE = new AuthHandler();

    private AuthHandler() {
        // do nothing
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!ctx.channel().attr(Attributes.LOGIN).get()) {
            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setSuccess(false);
            loginResponsePacket.setMsg("未登录");
            ctx.channel().writeAndFlush(loginResponsePacket);
        } else {
            ctx.pipeline().remove(this);
            super.channelRead(ctx, msg);
        }
    }

}
