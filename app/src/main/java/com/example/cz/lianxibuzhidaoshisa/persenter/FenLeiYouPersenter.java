package com.example.cz.lianxibuzhidaoshisa.persenter;

import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiBean;
import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiYouBean;
import com.example.cz.lianxibuzhidaoshisa.model.MyFenLeiYouCallBack;
import com.example.cz.lianxibuzhidaoshisa.model.MyFenLeiYouModel;
import com.example.cz.lianxibuzhidaoshisa.view.FenLeiView;
import com.example.cz.lianxibuzhidaoshisa.view.FenLeiYouView;

/**
 * Created by CZ on 2018/1/3.
 */

public class FenLeiYouPersenter {
    FenLeiYouView view;
    private final MyFenLeiYouModel model;

    public FenLeiYouPersenter(FenLeiYouView view) {
        this.view = view;
        model = new MyFenLeiYouModel();
    }

    public void getData(String cid) {
        model.get(cid, new MyFenLeiYouCallBack() {
            @Override
            public void success(FenLeiYouBean bean) {
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
    public void dsds(){
        this.view = null;
    }
}
