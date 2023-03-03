package com.project.proxy.client;

public class ClientApplication {

    public static void main(String[] args) {
        ClientLauncher clientLauncher = new ClientLauncher();
        clientLauncher.init();
        clientLauncher.run();
    }

}
