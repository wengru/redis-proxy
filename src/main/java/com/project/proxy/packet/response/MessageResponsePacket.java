package com.project.proxy.packet.response;

import com.project.proxy.packet.Packet;
import com.project.proxy.protocol.CommandEnum;

/**
 * @author hanxin
 * @date 2023/3/5 23:47
 */
public class MessageResponsePacket extends Packet {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return CommandEnum.MESSAGE_RESPONSE.getCode().byteValue();
    }

}
