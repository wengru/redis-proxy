package client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import packet.LoginPacket;
import protocol.PacketCodeC;

public class TestHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        /*ByteBuf msg = null;
        for (int i=0; i<100; i++) {
            String str = "客户端第" + (new Integer(i).toString()) + "次发送请求到服务端";
            System.out.println(str);
            byte[] bytes = str.getBytes();
            msg = Unpooled.buffer(bytes.length);
            msg.writeBytes(bytes);ctx.writeAndFlush(msg);
        }*/
        LoginPacket packet = new LoginPacket();
        packet.setUsername("abc");
        ByteBuf byteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), packet);
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object loginResponsePacket) {
        System.out.println(loginResponsePacket.toString());
    }

}
