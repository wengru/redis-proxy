package handler;

import com.alibaba.fastjson.JSON;
import exception.PacketException;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import protocol.Packet;
import protocol.PacketCodeC;

public class PacketHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("测试消息协议转换...");
        ByteBuf msgBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(msgBuf);
        if (packet == null) {
            throw new PacketException();
        }
        System.out.println("json data: " + JSON.toJSONString(packet));

    }

}
