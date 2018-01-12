package com.example.cz.lianxibuzhidaoshisa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cz.lianxibuzhidaoshisa.adapter.GoWuCheAdapter;
import com.example.cz.lianxibuzhidaoshisa.bean.AddGoWuCheBean;
import com.example.cz.lianxibuzhidaoshisa.bean.XiangQingBean;
import com.example.cz.lianxibuzhidaoshisa.event.UserEvent;
import com.example.cz.lianxibuzhidaoshisa.persenter.AddGoWuChePersenter;
import com.example.cz.lianxibuzhidaoshisa.persenter.XiangQingPersenter;
import com.example.cz.lianxibuzhidaoshisa.view.AddGoWuCheView;
import com.example.cz.lianxibuzhidaoshisa.view.XiangQingView;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiangQingActivity extends AppCompatActivity implements XiangQingView, AddGoWuCheView {

    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.gowuche)
    LinearLayout gowuche;
    @BindView(R.id.addgowuche)
    TextView addgowuche;
    @BindView(R.id.simple)
    SimpleDraweeView simple;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.xinxi)
    TextView xinxi;
    @BindView(R.id.price)
    TextView price;

    XiangQingPersenter persenter = new XiangQingPersenter(this);
    AddGoWuChePersenter persenter2 = new AddGoWuChePersenter(this);
    List<XiangQingBean> list = new ArrayList<XiangQingBean>();
    private int pid;
    private GoWuCheAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        ButterKnife.bind(this);
        EventBus.getDefault().register(XiangQingActivity.this);
//        Intent intent = getIntent();
//        String pid = intent.getStringExtra("pid");
//        persenter.getData(pid + "", "android");
        adapter = new GoWuCheAdapter(this);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void success(XiangQingBean bean) {
        Toast.makeText(XiangQingActivity.this, bean.getMsg() + "", Toast.LENGTH_SHORT).show();
        pid = bean.getData().getPid();
//        Toast.makeText(XiangQingActivity.this, bean.beangetData().getTitle(), Toast.LENGTH_SHORT).show();
        String[] split = bean.getData().getImages().split("\\|");
        simple.setImageURI(Uri.parse(split[0]));
        title.setText(bean.getData().getTitle());
        xinxi.setText(bean.getData().getSubhead());
        price.setText("￥:" + bean.getData().getPrice());
    }

    @Override
    public void success(AddGoWuCheBean bean) {
        Toast.makeText(XiangQingActivity.this, bean.getMsg() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failuer(String e) {
        Toast.makeText(XiangQingActivity.this, "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(XiangQingActivity.this);
        persenter.dsds();
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMoonEvent(UserEvent userEvent) {
//        tv_b.setText("账号："+userevent.getUsername()+"密码："+userevent.getPasswork());
        persenter.getData(userEvent.getPid() + "", "android");
    }

    @OnClick({R.id.gowuche, R.id.addgowuche})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.gowuche:

                break;
            case R.id.addgowuche:
                persenter2.getData(pid + "", "100", "android");
                adapter.notifyDataSetChanged();
                break;
        }
    }


}
