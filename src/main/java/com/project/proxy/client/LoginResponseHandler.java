package com.project.proxy.client;

import com.project.proxy.packet.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket packet) {
        if (packet.getSuccess()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败：" + packet.getMsg());
        }
    }

}
