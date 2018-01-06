package com.example.cz.lianxibuzhidaoshisa.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.cz.lianxibuzhidaoshisa.CustomView;
import com.example.cz.lianxibuzhidaoshisa.R;
import com.example.cz.lianxibuzhidaoshisa.SouSuoActivity;
import com.example.cz.lianxibuzhidaoshisa.adapter.ShouYeGridAdapter;
import com.example.cz.lianxibuzhidaoshisa.adapter.ShouyeAdapter;
import com.example.cz.lianxibuzhidaoshisa.bean.ShouYeBean;
import com.example.cz.lianxibuzhidaoshisa.persenter.ShouYePersenter;
import com.example.cz.lianxibuzhidaoshisa.view.ShouYeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_01 extends Fragment implements ShouYeView {
    @BindView(R.id.shaomian)
    LinearLayout shaomian;
    @BindView(R.id.sousou)
    ImageView sousou;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.gridview)
    CustomView gridview;


    private View view;
    private Unbinder unbinder;
    ShouYePersenter persenter = new ShouYePersenter(this);
    private List<String> imageArray;
    List<ShouYeBean.MiaoshaBean.ListBeanX> list = new ArrayList<ShouYeBean.MiaoshaBean.ListBeanX>();
    List<ShouYeBean.TuijianBean.ListBean> listbean = new ArrayList<ShouYeBean.TuijianBean.ListBean>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_01, container, false);
        unbinder = ButterKnife.bind(this, view);
        persenter.getData();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerview.setLayoutManager(manager);
        sousou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SouSuoActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


    @Override
    public void success(ShouYeBean bean) {
        Log.e("dd-----------", bean.getData().get(0).getTitle());
        inteite(bean);
        innini(bean);
        iniuu(bean);
    }

    private void iniuu(ShouYeBean bean) {
        for (int i = 0; i < bean.getTuijian().getList().size(); i++) {
            listbean.add(bean.getTuijian().getList().get(i));
        }
        ShouYeGridAdapter adapter = new ShouYeGridAdapter(getActivity(), listbean);
        gridview.setAdapter(adapter);
    }

    private void innini(ShouYeBean bean) {
        for (int i = 0; i < bean.getMiaosha().getList().size(); i++) {
            list.add(bean.getMiaosha().getList().get(i));
        }
        ShouyeAdapter adapter = new ShouyeAdapter(getActivity(), list);
        recyclerview.setAdapter(adapter);
    }

    private void inteite(ShouYeBean bean) {
        imageArray = new ArrayList<>();
        imageArray.add(bean.getData().get(0).getIcon());
        imageArray.add(bean.getData().get(1).getIcon());
        imageArray.add(bean.getData().get(2).getIcon());
        imageArray.add(bean.getData().get(3).getIcon());
        //设置banner样式    这个也可以换了直接点<span style="background-color:#e4e4ff;">CIRCLE_INDICATOR就可以不用添加标题和动画了</span>
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(imageArray);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

    }

    @Override
    public void failuer(Exception e) {
        Toast.makeText(getActivity(), "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        persenter.sdsdsd();
    }
}
