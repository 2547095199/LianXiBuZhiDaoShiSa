package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.app.MyApp;
import com.example.cz.lianxibuzhidaoshisa.bean.SouSuoBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CZ on 2018/1/6.
 */

public class MySouSuoModel implements SouSuoModel {

    @Override
    public void get(String keywords, String page, String source, final MySouSuoCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("keywords", keywords);
        map.put("page", page);
        map.put("source", source);
        MyApp.inters.getSS(map).enqueue(new Callback<SouSuoBean>() {
            @Override
            public void onResponse(Call<SouSuoBean> call, Response<SouSuoBean> response) {
                SouSuoBean body = response.body();
                callBack.success(body);
            }

            @Override
            public void onFailure(Call<SouSuoBean> call, Throwable t) {
                callBack.failuer(t.getMessage());
            }
        });
    }
}
