package com.project.proxy.client.handler;

import com.project.proxy.packet.response.MessageResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author hanxin
 * @date 2023/3/6 0:44
 */
@ChannelHandler.Sharable
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {

    public static final MessageResponseHandler INSTANCE = new MessageResponseHandler();

    private MessageResponseHandler() {
        // do nothing
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket packet) {
        System.out.println("接收到服务端消息：" + packet.getMessage());
    }

}
