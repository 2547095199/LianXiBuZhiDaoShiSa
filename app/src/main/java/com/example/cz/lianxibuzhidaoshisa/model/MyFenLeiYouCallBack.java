package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiBean;
import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiYouBean;

/**
 * Created by CZ on 2018/1/3.
 */

public interface MyFenLeiYouCallBack {
    public void success(FenLeiYouBean bean);

    public void failuer(String e);
}
