package com.example.cz.lianxibuzhidaoshisa.persenter;

import com.example.cz.lianxibuzhidaoshisa.bean.ShouYeBean;
import com.example.cz.lianxibuzhidaoshisa.model.ShouYeModel;
import com.example.cz.lianxibuzhidaoshisa.okhttp.OnUiCallback;
import com.example.cz.lianxibuzhidaoshisa.view.ShouYeView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by CZ on 2017/12/29.
 */

public class ShouYePersenter {
    ShouYeView view;
    private final ShouYeModel model;

    public ShouYePersenter(ShouYeView view) {
        this.view = view;
        model = new ShouYeModel();
    }

    public void getData() {
        model.get(new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {
                if (view != null) {
                    view.failuer(e);
                }
            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ShouYeBean bean = gson.fromJson(result, ShouYeBean.class);
                view.success(bean);
            }
        });
    }

    public void sdsdsd() {
        this.view = null;
    }
}
