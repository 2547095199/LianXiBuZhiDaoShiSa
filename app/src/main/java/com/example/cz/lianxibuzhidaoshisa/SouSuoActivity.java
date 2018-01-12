package com.example.cz.lianxibuzhidaoshisa;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cz.lianxibuzhidaoshisa.adapter.SouSuoAdapter;
import com.example.cz.lianxibuzhidaoshisa.bean.SouSuoBean;
import com.example.cz.lianxibuzhidaoshisa.persenter.SouSuoPersenter;
import com.example.cz.lianxibuzhidaoshisa.view.SouSuoView;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SouSuoActivity extends AppCompatActivity implements SouSuoView {

    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.shangname)
    EditText shangname;
    @BindView(R.id.sousuo)
    Button sousuo;
    @BindView(R.id.springview)
    SpringView springview;
    @BindView(R.id.image)
    ImageView mImage;

    SouSuoPersenter persenter = new SouSuoPersenter(this);
    List<SouSuoBean.DataBean> list = new ArrayList<SouSuoBean.DataBean>();

    private int page = 1;
    private boolean flag = true;
    private SouSuoAdapter adapter;
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou_suo);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(SouSuoActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(manager);

        ButterKnife.bind(this);
//        persenter.getData("笔记本", "1", "android");
        springview.setHeader(new DefaultHeader(this));
        springview.setFooter(new DefaultFooter(this));
        //设置SpringView的刷新监听事件
        springview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                springview.onFinishFreshAndLoad();
                finishFreshAndLoad();

            }

            @Override
            public void onLoadmore() {
                page++;
                if (TextUtils.isEmpty(shangname.getText().toString())) {
                    persenter.getData("笔记本", page + "", "android");
                } else {
                    persenter.getData(shangname.getText().toString() + "", page + "", "android");
                }

                adapter = new SouSuoAdapter(SouSuoActivity.this, list, flag);
                recyclerview.setAdapter(adapter);
                finishFreshAndLoad();


            }
        });

        inini();

    }

    private void finishFreshAndLoad() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                springview.onFinishFreshAndLoad();
            }
        }, 1000);
    }


    private void inini() {
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false) {
                    flag = true;
                    mImage.setImageResource(R.drawable.san);
                    LinearLayoutManager manager = new LinearLayoutManager(SouSuoActivity.this, LinearLayoutManager.VERTICAL, false);
                    recyclerview.setLayoutManager(manager);
                    adapter = new SouSuoAdapter(SouSuoActivity.this, list, flag);
                    recyclerview.setAdapter(adapter);
                } else if (flag == true) {
                    flag = false;
                    mImage.setImageResource(R.drawable.si);
                    GridLayoutManager manager = new GridLayoutManager(SouSuoActivity.this, 2);
                    recyclerview.setLayoutManager(manager);
                    adapter = new SouSuoAdapter(SouSuoActivity.this, list, flag);
                    recyclerview.setAdapter(adapter);
                }
            }
        });
        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                if (flag == true) {
                    persenter.getData(shangname.getText().toString(), "1", "android");
                    LinearLayoutManager manager = new LinearLayoutManager(SouSuoActivity.this, LinearLayoutManager.VERTICAL, false);
                    recyclerview.setLayoutManager(manager);
                    adapter = new SouSuoAdapter(SouSuoActivity.this, list, flag);
                    recyclerview.setAdapter(adapter);
                } else if (flag == false) {
                    persenter.getData(shangname.getText().toString(), "1", "android");
                    GridLayoutManager manager = new GridLayoutManager(SouSuoActivity.this, 2);
                    recyclerview.setLayoutManager(manager);
                    adapter = new SouSuoAdapter(SouSuoActivity.this, list, flag);
                    recyclerview.setAdapter(adapter);

                }

            }
        });
    }

    private void setadapter() {

        if (adapter != null) {
            adapter = new SouSuoAdapter(this, list, flag);
            recyclerview.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void success(SouSuoBean bean) {
        for (int i = 0; i < bean.getData().size(); i++) {
            list.add(bean.getData().get(i));
        }
//        list.addAll(bean.getData());
        adapter = new SouSuoAdapter(this, list, flag);
        recyclerview.setAdapter(adapter);
//        setadapter();
    }

    @Override
    public void failuer(String e) {
        Toast.makeText(SouSuoActivity.this, "错误", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.dssd();
    }
}
