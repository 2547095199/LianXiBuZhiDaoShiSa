package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.app.MyApp;
import com.example.cz.lianxibuzhidaoshisa.bean.AddGoWuCheBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CZ on 2018/1/5.
 */

public class MyAddGoWuCheModel implements AddGoWuCheModel {

    @Override
    public void get(String pid, String uid, String source, final MyAddGoWuCheCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pid", pid);
        map.put("uid", uid);
        map.put("source", source);
        MyApp.inters.getAGWC(map).enqueue(new Callback<AddGoWuCheBean>() {
            @Override
            public void onResponse(Call<AddGoWuCheBean> call, Response<AddGoWuCheBean> response) {
                AddGoWuCheBean body = response.body();
                callBack.success(body);
            }

            @Override
            public void onFailure(Call<AddGoWuCheBean> call, Throwable t) {
                callBack.failuer(t.getMessage());
            }
        });
    }
}
