package com.project.proxy.client.command;

import com.project.proxy.packet.LoginRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author cst
 * @date 2023/3/4 0:44
 */
public class LoginCommand implements ConsoleCommand {

    @Override
    public void execute(Scanner scanner, Channel channel) {
        System.out.println("请输入账号：");
        String account = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        System.out.println("\"" + account + "\"账号开始登录");
        LoginRequestPacket packet = new LoginRequestPacket();
        packet.setAccount(account);
        packet.setPassword(password);
        channel.writeAndFlush(packet);
        try {
            // 等待1秒后执行下一条命令
            Thread.sleep(1000L);
        } catch (Exception ignore) {
        }
    }

}
