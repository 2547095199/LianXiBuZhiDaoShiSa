package com.example.cz.lianxibuzhidaoshisa.event;

/**
 * Created by CZ on 2018/1/8.
 */

public class UserEvent {
    private String pid;

    public UserEvent(String pid) {
        this.pid = pid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "pid='" + pid + '\'' +
                '}';
    }
}
