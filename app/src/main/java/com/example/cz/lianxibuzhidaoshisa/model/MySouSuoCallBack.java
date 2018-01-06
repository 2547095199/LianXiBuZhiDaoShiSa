package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.bean.SouSuoBean;

/**
 * Created by CZ on 2018/1/6.
 */

public interface MySouSuoCallBack {
    public void success(SouSuoBean bean);

    public void failuer(String e);
}
