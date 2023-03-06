package com.project.proxy.client;

import com.project.proxy.Launcher;
import com.project.proxy.handler.MessageHandler;
import com.project.proxy.protocol.PacketDecoder;
import com.project.proxy.protocol.PacketEncoder;
import com.project.proxy.protocol.Spliter;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ClientLauncher implements Launcher {

    private static final String HOST = "127.0.0.1";

    private static final int PORT = 8081;

    @Override
    public void init() {
        // todo
    }

    @Override
    public void run() {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(new PacketDecoder());
                        ch.pipeline().addLast(new LoginResponseHandler());
                        ch.pipeline().addLast(new MessageHandler());
                        ch.pipeline().addLast(new PacketEncoder());
                    }
                });
        bootstrap.connect(HOST, PORT).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("客户端启动成功，连接服务端：" + HOST + ":" + PORT);
                // 新起一个线程，循环读取键盘输入
                new Thread(() -> {
                    try {
                        CommandManager.start(((ChannelFuture) future).channel());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            } else {
                System.out.println("launcher error");
            }
        });
    }

    @Override
    public void after() {
        //
    }

}
