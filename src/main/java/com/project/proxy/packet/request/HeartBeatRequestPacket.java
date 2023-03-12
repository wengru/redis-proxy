package com.project.proxy.packet.request;

import com.project.proxy.packet.RequestPacket;
import com.project.proxy.protocol.CommandEnum;

/**
 * @author hanxin
 * @date 2023/3/12 19:05
 */
public class HeartBeatRequestPacket extends RequestPacket {

    @Override
    public Byte getCommand() {
        return CommandEnum.HEART_BEAT_REQUEST.getCode().byteValue();
    }

}
