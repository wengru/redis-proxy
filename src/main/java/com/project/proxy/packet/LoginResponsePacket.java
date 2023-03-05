package com.project.proxy.packet;

/**
 * @author cst
 * @date 2023/3/4 0:10
 */
public class LoginResponsePacket {

    private Boolean success;

    private String uid;

    private String username;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

}
