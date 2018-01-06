package com.example.cz.lianxibuzhidaoshisa.eventbus;

/**
 * Created by CZ on 2018/1/5.
 */

public class UserEvent {
    private String position;

    public UserEvent(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "position='" + position + '\'' +
                '}';
    }
}
