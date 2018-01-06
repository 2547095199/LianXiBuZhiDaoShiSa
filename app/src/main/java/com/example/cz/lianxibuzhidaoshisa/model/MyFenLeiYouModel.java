package com.example.cz.lianxibuzhidaoshisa.model;

import android.util.Log;

import com.example.cz.lianxibuzhidaoshisa.app.MyApp;
import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiBean;
import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiYouBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CZ on 2018/1/3.
 */

public class MyFenLeiYouModel implements FenLeiYouModel {

    @Override
    public void get(String cid, final MyFenLeiYouCallBack callBack) {
        MyApp.inters.getData(cid).enqueue(new Callback<FenLeiYouBean>() {
            @Override
            public void onResponse(Call<FenLeiYouBean> call, Response<FenLeiYouBean> response) {
                FenLeiYouBean body = response.body();
                Log.i("body",body.getData().get(0).getName());

                callBack.success(body);
            }

            @Override
            public void onFailure(Call<FenLeiYouBean> call, Throwable t) {
                callBack.failuer(t.getMessage());
            }
        });
    }
}
