package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.bean.XiangQingBean;

/**
 * Created by CZ on 2018/1/5.
 */

public interface MyXiangQingCallBack {
    public void success(XiangQingBean bean);

    public void failuer(String e);
}
