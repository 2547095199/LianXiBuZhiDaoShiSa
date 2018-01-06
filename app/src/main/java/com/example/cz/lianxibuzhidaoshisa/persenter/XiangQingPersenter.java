package com.example.cz.lianxibuzhidaoshisa.persenter;

import com.example.cz.lianxibuzhidaoshisa.bean.XiangQingBean;
import com.example.cz.lianxibuzhidaoshisa.model.MyXiangQingCallBack;
import com.example.cz.lianxibuzhidaoshisa.model.MyXiangQingModel;
import com.example.cz.lianxibuzhidaoshisa.view.XiangQingView;

/**
 * Created by CZ on 2018/1/5.
 */

public class XiangQingPersenter {
    XiangQingView view;
    private final MyXiangQingModel model;

    public XiangQingPersenter(XiangQingView view) {
        this.view = view;
        model = new MyXiangQingModel();
    }
    public void getData(String pid,String source){
        model.get(pid, source, new MyXiangQingCallBack() {
            @Override
            public void success(XiangQingBean bean) {
                if (view != null){
                    view.success(bean);
                }
            }

            @Override
            public void failuer(String e) {
                if (view != null){
                    view.failuer(e);
                }
            }
        });
    }
    public void dsds(){
        this.view = null;
    }
}
