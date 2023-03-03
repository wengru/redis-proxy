package com.project.proxy;

public class ServerApplication {

    public static void main(String[] args) {
        RedisProxyServer redisProxyServer = new RedisProxyServer();
        redisProxyServer.init();
        redisProxyServer.run();
    }

}
