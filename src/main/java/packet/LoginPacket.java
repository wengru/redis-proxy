package packet;

import protocol.CommandEnum;
import protocol.Packet;

public class LoginPacket extends Packet {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Byte getCommand() {
        return CommandEnum.LOGIN.getCode().byteValue();
    }
}
