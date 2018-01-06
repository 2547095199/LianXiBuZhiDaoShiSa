package com.example.cz.lianxibuzhidaoshisa.view;

import com.example.cz.lianxibuzhidaoshisa.bean.ShouYeBean;

/**
 * Created by CZ on 2017/12/29.
 */

public interface ShouYeView {
    public void success(ShouYeBean bean);

    public void failuer(Exception e);
}
