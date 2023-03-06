package com.project.proxy.handler;

import com.project.proxy.constant.Attributes;
import com.project.proxy.packet.LoginRequestPacket;
import com.project.proxy.packet.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author hanxin
 * @date 2023/3/5 21:58
 */
public class AuthHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!ctx.channel().attr(Attributes.LOGIN).get()) {
            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setSuccess(false);
            ctx.channel().writeAndFlush(loginResponsePacket);
        } else {
            super.channelRead(ctx, msg);
        }
    }

}
