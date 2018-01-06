package com.example.cz.lianxibuzhidaoshisa.persenter;

import com.example.cz.lianxibuzhidaoshisa.bean.GoWuCheBean;
import com.example.cz.lianxibuzhidaoshisa.model.MyGoWuCheCallBack;
import com.example.cz.lianxibuzhidaoshisa.model.MyGoWuCheModel;
import com.example.cz.lianxibuzhidaoshisa.view.GoWuCheView;

/**
 * Created by CZ on 2018/1/5.
 */

public class GoWuChePersenter {
    GoWuCheView view;
    private final MyGoWuCheModel model;

    public GoWuChePersenter(GoWuCheView view) {
        this.view = view;
        model = new MyGoWuCheModel();
    }

    public void getData(String uid, String source) {
        model.get(uid, source, new MyGoWuCheCallBack() {
            @Override
            public void success(GoWuCheBean bean) {
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

    public void dfdfdf() {
        this.view = null;
    }
}
