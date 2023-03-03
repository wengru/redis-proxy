package com.project.proxy.packet;

import com.project.proxy.protocol.CommandEnum;

public class LoginRequestPacket extends Packet {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Byte getCommand() {
        return CommandEnum.LOGIN.getCode().byteValue();
    }
}
