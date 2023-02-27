package protocol;

import com.alibaba.fastjson.annotation.JSONField;

public abstract class Packet {

    @JSONField(serialize = false, deserialize = false)
    private Byte version = 1;

    public abstract Byte getCommand();

}
