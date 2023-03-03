package com.project.proxy.protocol;

import com.alibaba.fastjson.JSON;

public class JsonSerializer implements Serializer {

    public static final Serializer INSTANCE = new JsonSerializer();

    private JsonSerializer() {
        // do nothing
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deSerialize(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }

}
