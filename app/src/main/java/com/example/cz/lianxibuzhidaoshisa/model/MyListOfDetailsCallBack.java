package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.bean.ListOfDetailsBean;

/**
 * Created by CZ on 2018/1/4.
 */

public interface MyListOfDetailsCallBack {
    public void success(ListOfDetailsBean bean);

    public void failuer(String e);
}
