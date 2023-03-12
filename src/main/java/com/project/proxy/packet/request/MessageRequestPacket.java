package com.project.proxy.packet.request;

import com.project.proxy.packet.RequestPacket;
import com.project.proxy.protocol.CommandEnum;

/**
 * @author hanxin
 * @date 2023/3/6 0:26
 */
public class MessageRequestPacket extends RequestPacket {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return CommandEnum.MESSAGE_REQUEST.getCode().byteValue();
    }

}
