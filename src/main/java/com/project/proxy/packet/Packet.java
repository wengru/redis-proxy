package com.project.proxy.packet;

import com.alibaba.fastjson.annotation.JSONField;

public abstract class Packet {

    private transient Byte version = 1;

    @JSONField(serialize = false, deserialize = false)
    public abstract Byte getCommand();

}
