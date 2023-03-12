package com.project.proxy.handler;

import com.project.proxy.packet.Packet;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanxin
 * @date 2023/3/12 1:27
 */
@ChannelHandler.Sharable
public class DispatchHandler extends SimpleChannelInboundHandler<Packet> {

    public static final DispatchHandler INSTANCE = new DispatchHandler();

    private final Map<Byte, SimpleChannelInboundHandler<? extends Packet>> handlerMap = new HashMap<>();

    private DispatchHandler() {
        handlerMap.put(new Byte("2"), MessageHandler.INSTANCE);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet packet) throws Exception {
        handlerMap.get(packet.getCommand()).channelRead(ctx, packet);
    }

}
