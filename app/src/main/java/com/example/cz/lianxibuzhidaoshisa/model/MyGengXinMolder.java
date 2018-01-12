package com.example.cz.lianxibuzhidaoshisa.model;

import com.example.cz.lianxibuzhidaoshisa.app.MyApp;
import com.example.cz.lianxibuzhidaoshisa.bean.GengXinBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/12.
 */

public class MyGengXinMolder {
    //http://120.27.23.105/product/updateCarts?uid=100&sellerid=1&pid=45&selected=0&num=3
    public void get(String uid, String sellerid, String pid, String selected, String num, final MyGengXinCallBcak callBcak) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("sellerid", sellerid);
        map.put("pid", pid);
        map.put("selected", selected);
        map.put("num", num);
        MyApp.inters.getGX(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GengXinBean>() {
                    @Override
                    public void accept(GengXinBean bean) throws Exception {
                        callBcak.success(bean);
                    }
                });
    }
}
