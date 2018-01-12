package com.example.cz.lianxibuzhidaoshisa.inters;


import com.example.cz.lianxibuzhidaoshisa.bean.AddGoWuCheBean;
import com.example.cz.lianxibuzhidaoshisa.bean.DeleteBean;
import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiBean;
import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiYouBean;
import com.example.cz.lianxibuzhidaoshisa.bean.GengXinBean;
import com.example.cz.lianxibuzhidaoshisa.bean.GoWuCheBean;
import com.example.cz.lianxibuzhidaoshisa.bean.ListOfDetailsBean;
import com.example.cz.lianxibuzhidaoshisa.bean.SouSuoBean;
import com.example.cz.lianxibuzhidaoshisa.bean.XiangQingBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by CZ on 2018/1/3.
 */

public interface Inters {
    //分类左边listview的接口
    //http://120.27.23.105/product/getCatagory
    @GET("/product/getCatagory")
    Call<FenLeiBean> get();

    //分类右边页面接口
    //http://120.27.23.105/product/getProductCatagory?cid=1
    @GET("/product/getProductCatagory")
    Call<FenLeiYouBean> getData(@Query("cid") String cid);

    //详情列表页面接口
    //http://120.27.23.105/product/getProducts?pscid=1&page=2
    @GET("/product/getProducts")
    Call<ListOfDetailsBean> getLOD(@QueryMap HashMap<String, String> map);

    //详情页面接口
    //http://120.27.23.105/product/getProductDetail?pid=1&source=android
    @GET("/product/getProductDetail")
    Call<XiangQingBean> getXQ(@QueryMap HashMap<String, String> map);

    //添加购物车接口
    //http://120.27.23.105/product/addCart?pid=75&uid=75&source=android
    @GET("/product/addCart")
    Call<AddGoWuCheBean> getAGWC(@QueryMap HashMap<String, String> map);

    //购物车接口
    //120.27.23.105/product/getCarts?uid=75&source=android
    @GET("/product/getCarts")
    Call<GoWuCheBean> getGWC(@QueryMap HashMap<String, String> map);

    //搜索接口
    //http://120.27.23.105/product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1&source=android
    @GET("/product/searchProducts")
    Call<SouSuoBean> getSS(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/deleteCart?uid=100&pid=1
    @GET("/product/deleteCart")
    Observable<DeleteBean> getD(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/updateCarts?uid=100&sellerid=1&pid=45&selected=0&num=3
    @GET("/product/updateCarts")
    Observable<GengXinBean> getGX(@QueryMap HashMap<String, String> map);
}
