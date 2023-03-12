package com.project.proxy.handler;

import com.project.proxy.packet.Packet;
import com.project.proxy.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

/**
 * @author hanxin
 * @date 2023/3/12 1:13
 */
@ChannelHandler.Sharable
public class PacketCodeCHandler extends MessageToMessageCodec<ByteBuf, Packet> {

    public static final PacketCodeCHandler INSTANCE = new PacketCodeCHandler();

    private PacketCodeCHandler() {
        // do nothing
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Packet msg, List<Object> out) throws Exception {
        ByteBuf byteBuf = ctx.channel().alloc().ioBuffer();
        PacketCodeC.INSTANCE.encode(byteBuf, msg);
        out.add(byteBuf);
    }
    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        out.add(PacketCodeC.INSTANCE.decode(msg));
    }
}
