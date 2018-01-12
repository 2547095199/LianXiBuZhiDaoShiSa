package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.bean.GengXinBean;

/**
 * Created by CZ on 2018/1/12.
 */

public interface MyGengXinCallBcak {
    public void success(GengXinBean bean);

    public void failuer(String e);
}
