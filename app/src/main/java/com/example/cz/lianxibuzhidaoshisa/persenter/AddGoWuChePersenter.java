package com.example.cz.lianxibuzhidaoshisa.persenter;

import com.example.cz.lianxibuzhidaoshisa.bean.AddGoWuCheBean;
import com.example.cz.lianxibuzhidaoshisa.model.MyAddGoWuCheCallBack;
import com.example.cz.lianxibuzhidaoshisa.model.MyAddGoWuCheModel;
import com.example.cz.lianxibuzhidaoshisa.view.AddGoWuCheView;

/**
 * Created by CZ on 2018/1/5.
 */

public class AddGoWuChePersenter {
    AddGoWuCheView view;
    private final MyAddGoWuCheModel model;

    public AddGoWuChePersenter(AddGoWuCheView view) {
        this.view = view;
        model = new MyAddGoWuCheModel();
    }

    public void getData(String pid, String uid, String source) {
        model.get(pid, uid, source, new MyAddGoWuCheCallBack() {
            @Override
            public void success(AddGoWuCheBean bean) {
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

    public void ddsds() {
        this.view = null;
    }
}
