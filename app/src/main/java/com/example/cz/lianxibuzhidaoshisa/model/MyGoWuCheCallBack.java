package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.bean.GoWuCheBean;

/**
 * Created by CZ on 2018/1/5.
 */

public interface MyGoWuCheCallBack {
    public void success(GoWuCheBean bean);

    public void failuer(String e);
}
