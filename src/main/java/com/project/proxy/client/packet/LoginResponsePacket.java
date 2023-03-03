package com.project.proxy.client.packet;

/**
 * @author cst
 * @date 2023/3/4 0:10
 */
public class LoginResponsePacket {

    private String uid;

    private String username;

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
