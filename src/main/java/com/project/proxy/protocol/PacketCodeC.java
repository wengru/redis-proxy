package com.project.proxy.protocol;

import io.netty.buffer.ByteBuf;
import com.project.proxy.packet.Packet;

import java.util.HashMap;
import java.util.Map;

public class PacketCodeC {

    public static final int magicNumber = 0x12345678;

    private static final Map<Byte, Class<? extends Packet>> commandMap = new HashMap<>();

    private static final Map<Byte, Serializer> serializerMap = new HashMap<>();

    public static final PacketCodeC INSTANCE = new PacketCodeC();

    private PacketCodeC() {
        for (CommandEnum command : CommandEnum.values()) {
            commandMap.put(command.getCode().byteValue(), command.getType());
        }
        for (SerializerEnum serializer : SerializerEnum.values()) {
            serializerMap.put(serializer.getType().byteValue(), serializer.getSerializer());
        }
    }

    public void encode(ByteBuf byteBuf, Packet packet) {
        // 创建ByteBuf对象
        byteBuf.writeInt(magicNumber);
        byteBuf.writeByte(new Integer(1).byteValue()); // version todo remove
        byteBuf.writeByte(new Integer(0).byteValue()); // serializer algorithm
        byteBuf.writeByte(packet.getCommand());
        byte[] bytes = SerializerEnum.DEFAULT.getSerializer().serialize(packet);
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }

    public Packet decode(ByteBuf byteBuf) {
        // skip magic number
        byteBuf.skipBytes(4);
        // skip version
        byteBuf.skipBytes(1);
        // serialize algorithm
        Byte serializeAlgorithm = byteBuf.readByte();
        Serializer serializer = serializerMap.get(serializeAlgorithm);
        // command
        Byte command = byteBuf.readByte();
        Class<? extends Packet> commandPacket =  commandMap.get(command);
        if (serializer == null || commandPacket == null) {
            return null;
        }
        // 数据包长度
        int length = byteBuf.readInt();
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        return serializer.deSerialize(bytes, commandPacket);
    }

}
