package com.example.cz.lianxibuzhidaoshisa.persenter;

import com.example.cz.lianxibuzhidaoshisa.bean.SouSuoBean;
import com.example.cz.lianxibuzhidaoshisa.model.MySouSuoCallBack;
import com.example.cz.lianxibuzhidaoshisa.model.MySouSuoModel;
import com.example.cz.lianxibuzhidaoshisa.view.SouSuoView;

/**
 * Created by CZ on 2018/1/6.
 */

public class SouSuoPersenter {
    SouSuoView view;
    private final MySouSuoModel model;

    public SouSuoPersenter(SouSuoView view) {
        this.view = view;
        model = new MySouSuoModel();
    }

    public void getData(String keywords, String page, String source) {
        model.get(keywords, page, source, new MySouSuoCallBack() {
            @Override
            public void success(SouSuoBean bean) {
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

    public void dssd() {
        this.view = null;
    }
}
