package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.okhttp.OkHttp3Utils;

import okhttp3.Callback;


/**
 * Created by CZ on 2017/12/29.
 */

public class ShouYeModel {
    public void get(Callback callback){
        OkHttp3Utils.doGet("http://120.27.23.105/ad/getAd",callback);
    }
}
