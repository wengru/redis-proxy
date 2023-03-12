package com.project.proxy.client.handler;

import com.project.proxy.packet.response.LoginResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@ChannelHandler.Sharable
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    public static final LoginResponseHandler INSTANCE = new LoginResponseHandler();

    private LoginResponseHandler() {
        // do nothing
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket packet) {
        if (packet.getSuccess()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败：" + packet.getMsg());
        }
    }

}
