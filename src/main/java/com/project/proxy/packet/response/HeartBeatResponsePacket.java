package com.project.proxy.packet.response;

import com.project.proxy.packet.Packet;
import com.project.proxy.protocol.CommandEnum;

/**
 * @author hanxin
 * @date 2023/3/12 19:07
 */
public class HeartBeatResponsePacket extends Packet {

    @Override
    public Byte getCommand() {
        return CommandEnum.HEART_BEAT_RESPONSE.getCode().byteValue();
    }

}
