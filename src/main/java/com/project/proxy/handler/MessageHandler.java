package com.project.proxy.handler;

import com.alibaba.fastjson.JSON;
import com.project.proxy.packet.MessageRequestPacket;
import com.project.proxy.packet.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author hanxin
 * @date 2023/3/5 23:46
 */
public class MessageHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    public static final MessageHandler INSTANCE = new MessageHandler();

    private MessageHandler() {
        // do nothing
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {
        System.out.println("收到消息" + JSON.toJSONString(msg.getMessage()));
        MessageResponsePacket responsePacket = new MessageResponsePacket();
        responsePacket.setMessage(msg.getMessage());
        ctx.channel().writeAndFlush(responsePacket);
    }
}
