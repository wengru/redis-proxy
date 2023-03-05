package com.project.proxy.constant;

public class Session {

    private String uid;

    private String userName;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Session{" +
                "uid='" + uid + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

}
