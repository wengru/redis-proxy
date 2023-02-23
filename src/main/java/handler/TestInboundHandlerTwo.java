package handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TestInboundHandlerTwo extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("测试入站channel成功2");
        System.out.println("mesg: " + msg);
        ctx.writeAndFlush(msg);
    }

}
