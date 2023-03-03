package com.project.proxy.protocol;

public enum SerializerEnum {

    DEFAULT(0, JsonSerializer.INSTANCE),
    JSON(0, JsonSerializer.INSTANCE),
    ;

    private SerializerEnum(Integer type, Serializer serializer) {
        this.type = type;
        this.serializer = serializer;
    }

    private final Integer type;

    private final Serializer serializer;

    public Integer getType() {
        return type;
    }

    public Serializer getSerializer() {
        return serializer;
    }
}
