package com.project.proxy.protocol;

import com.project.proxy.packet.LoginRequestPacket;
import com.project.proxy.packet.MessageRequestPacket;
import com.project.proxy.packet.Packet;

public enum CommandEnum {

    LOGIN(0, LoginRequestPacket.class),
    MESSAGE(1, MessageRequestPacket.class)
    ;

    private CommandEnum(Integer code, Class<? extends Packet> type) {
        this.code = code;
        this.type = type;
    }

    private final Integer code;

    private final Class<? extends Packet> type;

    public Integer getCode() {
        return code;
    }

    public Class<? extends Packet> getType() {
        return type;
    }

}
