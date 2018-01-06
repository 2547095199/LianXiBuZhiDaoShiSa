package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.app.MyApp;
import com.example.cz.lianxibuzhidaoshisa.bean.XiangQingBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CZ on 2018/1/5.
 */

public class MyXiangQingModel implements XiangQingModel {
    @Override
    public void get(String pid, String source, final MyXiangQingCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pid", pid);
        map.put("source", source);

        MyApp.inters.getXQ(map).enqueue(new Callback<XiangQingBean>() {
            @Override
            public void onResponse(Call<XiangQingBean> call, Response<XiangQingBean> response) {
                XiangQingBean body = response.body();
                callBack.success(body);
            }

            @Override
            public void onFailure(Call<XiangQingBean> call, Throwable t) {
                callBack.failuer(t.getMessage());
            }
        });
    }
}
