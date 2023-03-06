package com.project.proxy.client;

import com.project.proxy.client.command.ConsoleCommand;
import com.project.proxy.client.command.LoginCommand;
import com.project.proxy.client.command.MessageCommand;
import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author cst
 * @date 2023/3/4 0:07
 */
public class CommandManager {

    private static Map<String, ConsoleCommand> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put("login", new LoginCommand());
        commandMap.put("message", new MessageCommand());
    }

    public static void start(Channel channel) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入命令：");
            String commandType = scanner.next();
            ConsoleCommand command = commandMap.get(commandType);
            if (command == null) {
                System.out.println("找不到对应的命令");
            }
            try {
                command.execute(scanner, channel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
