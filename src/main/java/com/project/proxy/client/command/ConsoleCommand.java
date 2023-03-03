package com.project.proxy.client.command;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author cst
 * @date 2023/3/4 0:32
 */
public interface ConsoleCommand {

    void execute(Scanner scanner, Channel channel);

}
