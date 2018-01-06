package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.bean.AddGoWuCheBean;

/**
 * Created by CZ on 2018/1/5.
 */

public interface MyAddGoWuCheCallBack {
    public void success(AddGoWuCheBean bean);

    public void failuer(String e);
}
