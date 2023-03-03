package com.project.proxy.client.command;

import com.project.proxy.client.packet.LoginRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author cst
 * @date 2023/3/4 0:44
 */
public class LoginCommand implements ConsoleCommand {

    @Override
    public void execute(Scanner scanner, Channel channel) {
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("\"" + username + "\"用户开始登录");
        LoginRequestPacket packet = new LoginRequestPacket();
        packet.setUsername(username);
        channel.writeAndFlush(packet);
    }

}
