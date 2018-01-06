package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.app.MyApp;
import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CZ on 2018/1/3.
 */

public class FenLeiModel {
    public void get(final MyFenLeiCallBack callBack){
        MyApp.inters.get().enqueue(new Callback<FenLeiBean>() {
            @Override
            public void onResponse(Call<FenLeiBean> call, Response<FenLeiBean> response) {
                FenLeiBean body = response.body();
                callBack.success(body);
            }

            @Override
            public void onFailure(Call<FenLeiBean> call, Throwable t) {
                callBack.failuer(t.getMessage());
            }
        });
    }
}
