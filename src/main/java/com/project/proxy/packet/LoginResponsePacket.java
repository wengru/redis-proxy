package com.project.proxy.packet;

import com.project.proxy.protocol.CommandEnum;

/**
 * @author cst
 * @date 2023/3/4 0:10
 */
public class LoginResponsePacket extends Packet {

    private Boolean success;

    private String msg;

    private String uid;

    private String username;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Byte getCommand() {
        return CommandEnum.LOGIN.getCode().byteValue();
    }

}
