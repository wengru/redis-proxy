package com.project.proxy.packet.request;

import com.project.proxy.packet.RequestPacket;
import com.project.proxy.protocol.CommandEnum;

public class LoginRequestPacket extends RequestPacket {

    private String account;

    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Byte getCommand() {
        return CommandEnum.LOGIN_REQUEST.getCode().byteValue();
    }

}
