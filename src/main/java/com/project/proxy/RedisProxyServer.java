package com.project.proxy;

import com.project.proxy.constant.Attributes;
import com.project.proxy.handler.*;
import com.project.proxy.protocol.Spliter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class RedisProxyServer implements Launcher {

    private static final int PORT = 8081;

    private static final int SO_BACKLOG = 1024;

    @Override
    public void init() {
        //
    }

    @Override
    public void run() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup(16);
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, SO_BACKLOG)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childAttr(Attributes.LOGIN, false) // 默认未登录
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new IdleDetectHandler());
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(PacketCodeCHandler.INSTANCE);
                        ch.pipeline().addLast(HeartBeatRequestHandler.INSTANCE);
                        ch.pipeline().addLast(LoginHandler.INSTANCE);
                        ch.pipeline().addLast(AuthHandler.INSTANCE);
                        ch.pipeline().addLast(DispatchHandler.INSTANCE);
                    }
                });
        serverBootstrap.bind(PORT).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("服务端启动成功，端口：" + PORT);
            } else {
                System.out.println("服务端启动失败");
            }
        });
    }

    @Override
    public void after() {
        //
    }

}
