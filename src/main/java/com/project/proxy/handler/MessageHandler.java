package com.project.proxy.handler;

import com.alibaba.fastjson.JSON;
import com.project.proxy.packet.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author hanxin
 * @date 2023/3/5 23:46
 */
public class MessageHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到消息" + JSON.toJSONString(msg));
        MessageResponsePacket responsePacket = new MessageResponsePacket();
        responsePacket.setMessage("success");
        ctx.writeAndFlush(msg);
    }
}
