package com.example.cz.lianxibuzhidaoshisa;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.cz.lianxibuzhidaoshisa.fragment.Fragment_01;
import com.example.cz.lianxibuzhidaoshisa.fragment.Fragment_02;
import com.example.cz.lianxibuzhidaoshisa.fragment.Fragment_03;
import com.example.cz.lianxibuzhidaoshisa.fragment.Fragment_04;
import com.example.cz.lianxibuzhidaoshisa.fragment.Fragment_05;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(80, 80)
                .setFontSize(10)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("首页", R.drawable.shouye1, Fragment_01.class)
                .addTabItem("分类", R.drawable.fenlei1, Fragment_02.class)
                .addTabItem("发现", R.drawable.faxian1, Fragment_03.class)
                .addTabItem("购物车", R.drawable.gowuche1, Fragment_04.class)
                .addTabItem("我的", R.drawable.wode1, Fragment_05.class)
                .setTabBarBackgroundColor(Color.WHITE)
                .isShowDivider(true);
    }

}
