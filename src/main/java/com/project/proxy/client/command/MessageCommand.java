package com.project.proxy.client.command;

import com.project.proxy.packet.MessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author hanxin
 * @date 2023/3/6 0:25
 */
public class MessageCommand implements ConsoleCommand {

    @Override
    public void execute(Scanner scanner, Channel channel) {
        System.out.println("请输入要发送的消息：");
        String message = scanner.next();
        MessageRequestPacket requestPacket = new MessageRequestPacket();
        requestPacket.setMessage(message);
        System.out.println("开始发送消息...");
        channel.writeAndFlush(requestPacket);
        try {
            // 等待1秒后执行下一条命令
            Thread.sleep(1000L);
        } catch (Exception ignore) {
        }
    }

}
