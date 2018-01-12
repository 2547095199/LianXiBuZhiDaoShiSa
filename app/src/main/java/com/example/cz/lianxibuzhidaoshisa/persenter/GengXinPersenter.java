package com.example.cz.lianxibuzhidaoshisa.persenter;

import com.example.cz.lianxibuzhidaoshisa.bean.GengXinBean;
import com.example.cz.lianxibuzhidaoshisa.model.MyGengXinCallBcak;
import com.example.cz.lianxibuzhidaoshisa.model.MyGengXinMolder;
import com.example.cz.lianxibuzhidaoshisa.view.GengXinView;

/**
 * Created by CZ on 2018/1/12.
 */

public class GengXinPersenter {
    GengXinView view;
    private final MyGengXinMolder molder;

    public GengXinPersenter(GengXinView view) {
        this.view = view;
        molder = new MyGengXinMolder();
    }

    public void getData(String uid, String sellerid, String pid, String selected, String num) {
        molder.get(uid, sellerid, pid, selected, num, new MyGengXinCallBcak() {
            @Override
            public void success(GengXinBean bean) {
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

//    public void ddsdsdsds() {
//        this.view = null;
//    }
}
