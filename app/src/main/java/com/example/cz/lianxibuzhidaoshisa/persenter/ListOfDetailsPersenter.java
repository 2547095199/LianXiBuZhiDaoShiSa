package com.example.cz.lianxibuzhidaoshisa.persenter;

import com.example.cz.lianxibuzhidaoshisa.bean.ListOfDetailsBean;
import com.example.cz.lianxibuzhidaoshisa.model.MyListOfDetailsCallBack;
import com.example.cz.lianxibuzhidaoshisa.model.MyListOfDetailsModel;
import com.example.cz.lianxibuzhidaoshisa.view.ListOfDetailsView;

/**
 * Created by CZ on 2018/1/4.
 */

public class ListOfDetailsPersenter {
    ListOfDetailsView view;
    private final MyListOfDetailsModel model;

    public ListOfDetailsPersenter(ListOfDetailsView view) {
        this.view = view;
        model = new MyListOfDetailsModel();
    }

    public void getData(String pscid, String page, String sort) {
        model.get(pscid, page, sort, new MyListOfDetailsCallBack() {
            @Override
            public void success(ListOfDetailsBean bean) {
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

    public void dsdsdds() {
        this.view = null;
    }
}
