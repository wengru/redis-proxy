package protocol;

import packet.LoginPacket;

public enum CommandEnum {

    LOGIN(1, LoginPacket.class),
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
