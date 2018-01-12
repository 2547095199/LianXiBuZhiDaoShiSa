package com.example.cz.lianxibuzhidaoshisa.persenter;

import android.content.Context;

import com.example.cz.lianxibuzhidaoshisa.bean.DeleteBean;
import com.example.cz.lianxibuzhidaoshisa.model.MyDeleteCallBack;
import com.example.cz.lianxibuzhidaoshisa.model.MyDeleteModel;
import com.example.cz.lianxibuzhidaoshisa.view.DeleteView;

/**
 * Created by CZ on 2018/1/11.
 */

public class DeletePersenter {
    DeleteView view;
//    Context context;
    private final MyDeleteModel model;

    public DeletePersenter(DeleteView view ) {
//        this.context =context;
        this.view = view;
        model = new MyDeleteModel();
    }

    public void getData(String uid, String pid) {
        model.get(uid, pid, new MyDeleteCallBack() {
            @Override
            public void success(DeleteBean bean) {
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

    public void dsdsdsdsds() {
        this.view = null;
    }
}
