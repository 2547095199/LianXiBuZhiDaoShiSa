package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiBean;

/**
 * Created by CZ on 2018/1/3.
 */

public interface MyFenLeiCallBack {
    public void success(FenLeiBean bean);
    public void failuer(String e);
}
