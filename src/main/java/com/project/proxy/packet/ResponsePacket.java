package com.project.proxy.packet;

/**
 * @author hanxin
 * @date 2023/3/5 22:58
 */
// todo 统一应用层响应协议
public abstract class ResponsePacket<T> extends Packet {

    private String code;

    private String msg;

    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
