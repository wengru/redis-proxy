package com.project.proxy.protocol;

import com.project.proxy.packet.*;
import com.project.proxy.packet.request.HeartBeatRequestPacket;
import com.project.proxy.packet.request.LoginRequestPacket;
import com.project.proxy.packet.response.HeartBeatResponsePacket;
import com.project.proxy.packet.response.LoginResponsePacket;
import com.project.proxy.packet.request.MessageRequestPacket;
import com.project.proxy.packet.response.MessageResponsePacket;

public enum CommandEnum {

    LOGIN_REQUEST(0, LoginRequestPacket.class),
    LOGIN_RESPONSE(1, LoginResponsePacket.class),
    MESSAGE_REQUEST(2, MessageRequestPacket.class),
    MESSAGE_RESPONSE(3, MessageResponsePacket.class),
    HEART_BEAT_REQUEST(4, HeartBeatRequestPacket.class),
    HEART_BEAT_RESPONSE(5, HeartBeatResponsePacket.class)
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
