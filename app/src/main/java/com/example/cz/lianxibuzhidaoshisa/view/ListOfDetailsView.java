package com.example.cz.lianxibuzhidaoshisa.view;

import com.example.cz.lianxibuzhidaoshisa.bean.ListOfDetailsBean;

/**
 * Created by CZ on 2018/1/4.
 */

public interface ListOfDetailsView {
    public void success(ListOfDetailsBean bean);

    public void failuer(String e);
}
