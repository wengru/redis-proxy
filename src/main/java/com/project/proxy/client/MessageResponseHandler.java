package com.project.proxy.client;

import com.project.proxy.packet.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author hanxin
 * @date 2023/3/6 0:44
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket packet) {
        System.out.println("接收到服务端消息：" + packet.getMessage());
    }

}
