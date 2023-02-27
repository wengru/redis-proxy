package protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.util.HashMap;
import java.util.Map;

public class PacketCodeC {

    private static final Integer magicNumber = 0x12345678;

    public static final PacketCodeC INSTANCE = new PacketCodeC();

    private static final Map<Byte, Class<? extends Packet>> commandMap = new HashMap<>();

    private static final Map<Byte, Serializer> serializerMap = new HashMap<>();

    private PacketCodeC() {
        for (CommandEnum command : CommandEnum.values()) {
            commandMap.put(command.getCode().byteValue(), command.getType());
        }
        for (SerializerEnum serializer : SerializerEnum.values()) {
            serializerMap.put(serializer.getType().byteValue(), serializer.getSerializer());
        }
    }

    public ByteBuf encode(ByteBufAllocator byteBufAllocator, Packet packet) {
        // 创建ByteBuf对象
        ByteBuf byteBuf = byteBufAllocator.ioBuffer();
        byteBuf.writeInt(magicNumber);
        byteBuf.writeByte(new Integer(1).byteValue());
        byteBuf.writeByte(packet.getCommand());
        byte[] bytes = SerializerEnum.DEFAULT.getSerializer().serialize(packet);
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
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
