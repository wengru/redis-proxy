package com.project.proxy.protocol;

import com.project.proxy.packet.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author cst
 * @date 2023/3/4 1:16
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) throws Exception {
        System.out.println("开始编码");
        PacketCodeC.INSTANCE.encode(ctx.alloc(), msg);
    }

}
