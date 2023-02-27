package handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

//@ChannelHandler.Sharable
public class TestInboundHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("测试入站channel成功1");
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("msg: " + byteBuf.toString(Charset.forName("utf-8")));
        ctx.fireChannelRead(msg);
    }

}
