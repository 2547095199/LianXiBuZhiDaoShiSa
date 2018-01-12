package com.example.cz.lianxibuzhidaoshisa;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

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

    //声明一个long类型变量：用于存放上一点击“返回键”的时刻
    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断用户是否点击了“返回键”
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //与上次点击返回键时刻作差
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                //大于2000ms则认为是误操作，使用Toast进行提示
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //并记录下本次点击“返回键”的时刻，以便下次进行判断
                mExitTime = System.currentTimeMillis();
            } else {
                //小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
