package com.example.cz.lianxibuzhidaoshisa.event;

/**
 * Created by CZ on 2018/1/12.
 */

public class UserEventBus {
    private int mCount;

    public UserEventBus(int mCount) {
        this.mCount = mCount;
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    @Override
    public String toString() {
        return "UserEventBus{" +
                "mCount=" + mCount +
                '}';
    }
}
