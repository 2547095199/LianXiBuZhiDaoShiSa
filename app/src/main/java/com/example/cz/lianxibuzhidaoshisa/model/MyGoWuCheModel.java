package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.app.MyApp;
import com.example.cz.lianxibuzhidaoshisa.bean.GoWuCheBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CZ on 2018/1/5.
 */

public class MyGoWuCheModel implements GoWuCheModel {
    @Override
    public void get(String uid, String source, final MyGoWuCheCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("source", source);
        MyApp.inters.getGWC(map).enqueue(new Callback<GoWuCheBean>() {
            @Override
            public void onResponse(Call<GoWuCheBean> call, Response<GoWuCheBean> response) {
                GoWuCheBean body = response.body();
                callBack.success(body);
            }

            @Override
            public void onFailure(Call<GoWuCheBean> call, Throwable t) {
                callBack.failuer(t.getMessage());
            }
        });
    }
}
