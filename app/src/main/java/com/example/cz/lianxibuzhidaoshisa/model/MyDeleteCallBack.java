package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.bean.DeleteBean;

/**
 * Created by CZ on 2018/1/11.
 */

public interface MyDeleteCallBack {
    public void success(DeleteBean bean);

    public void failuer(String e);
}
