package com.example.cz.lianxibuzhidaoshisa.view;

import com.example.cz.lianxibuzhidaoshisa.bean.DeleteBean;

/**
 * Created by CZ on 2018/1/11.
 */

public interface DeleteView {
    public void success(DeleteBean bean);

    public void failuer(String e);
}
