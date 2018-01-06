package com.example.cz.lianxibuzhidaoshisa.persenter;

import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiBean;
import com.example.cz.lianxibuzhidaoshisa.model.FenLeiModel;
import com.example.cz.lianxibuzhidaoshisa.model.MyFenLeiCallBack;
import com.example.cz.lianxibuzhidaoshisa.view.FenLeiView;

/**
 * Created by CZ on 2018/1/3.
 */

public class FenLiePersenter {
    FenLeiView view;
    private final FenLeiModel model;

    public FenLiePersenter(FenLeiView view) {
        this.view = view;
        model = new FenLeiModel();
    }

    public void getData() {
        model.get(new MyFenLeiCallBack() {
            @Override
            public void success(FenLeiBean bean) {
                if (view != null) {
                    view.success(bean);
                }
            }

            @Override
            public void failuer(String e) {
                if (view != null) {
                    view.failuer(e);
                }
            }

        });
    }

    public void dsdsdsd() {
        this.view = null;
    }
}
