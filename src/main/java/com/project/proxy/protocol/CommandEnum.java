package com.project.proxy.protocol;

import com.project.proxy.packet.*;

public enum CommandEnum {

    LOGIN_REQUEST(0, LoginRequestPacket.class),
    LOGIN_RESPONSE(1, LoginResponsePacket.class),
    MESSAGE_REQUEST(2, MessageRequestPacket.class),
    MESSAGE_RESPONSE(3, MessageResponsePacket.class)
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
