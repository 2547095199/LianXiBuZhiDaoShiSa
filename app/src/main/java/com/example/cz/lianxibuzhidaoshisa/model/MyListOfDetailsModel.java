package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.app.MyApp;
import com.example.cz.lianxibuzhidaoshisa.bean.ListOfDetailsBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CZ on 2018/1/4.
 */

public class MyListOfDetailsModel implements ListOfDetailsModel {

    @Override
    public void get(String pscid, String page, String sort, final MyListOfDetailsCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pscid", pscid);
        map.put("page", page);
        map.put("sort", sort);
        MyApp.inters.getLOD(map).enqueue(new Callback<ListOfDetailsBean>() {
            @Override
            public void onResponse(Call<ListOfDetailsBean> call, Response<ListOfDetailsBean> response) {
                ListOfDetailsBean body = response.body();
                callBack.success(body);
            }

            @Override
            public void onFailure(Call<ListOfDetailsBean> call, Throwable t) {
                callBack.failuer(t.getMessage());
            }
        });
    }
}
