package com.example.cz.lianxibuzhidaoshisa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cz.lianxibuzhidaoshisa.adapter.ListOfDetailsAdapter;
import com.example.cz.lianxibuzhidaoshisa.bean.ListOfDetailsBean;
import com.example.cz.lianxibuzhidaoshisa.event.UserEvent;
import com.example.cz.lianxibuzhidaoshisa.persenter.ListOfDetailsPersenter;
import com.example.cz.lianxibuzhidaoshisa.view.ListOfDetailsView;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListOfDetailsActivity extends AppCompatActivity implements ListOfDetailsView {

    ListOfDetailsPersenter persenter = new ListOfDetailsPersenter(this);
    List<ListOfDetailsBean.DataBean> list = new ArrayList<ListOfDetailsBean.DataBean>();
    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.sousuo)
    EditText sousuo;
    @BindView(R.id.tvZhonghe)
    TextView tvZhonghe;
    @BindView(R.id.tvXiaoliang)
    TextView tvXiaoliang;
    @BindView(R.id.tvPrice)
    TextView tvPrice;
    @BindView(R.id.tvShaixuan)
    TextView tvShaixuan;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.sv)
    SpringView sv;
    private int page = 1;
    private String pscid;
    private ListOfDetailsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        pscid = intent.getStringExtra("pscid");
        Toast.makeText(ListOfDetailsActivity.this, pscid + "", Toast.LENGTH_SHORT).show();
        persenter.getData(pscid + "", "1");

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        sv.setHeader(new DefaultHeader(this));
        sv.setFooter(new DefaultFooter(this));
        sv.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                persenter.getData(pscid, page + "");
                finishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                page++;
                persenter.getData(pscid, page + "");
                finishFreshAndLoad();

            }
        });

        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ListOfDetailsActivity.this, SouSuoActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void success(final ListOfDetailsBean bean) {
        for (int i = 0; i < bean.getData().size(); i++) {
            list.add(bean.getData().get(i));
        }
        adapter = new ListOfDetailsAdapter(ListOfDetailsActivity.this, list);
        rv.setAdapter(adapter);

        adapter.setOnItemClickListener(new ListOfDetailsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(ListOfDetailsActivity.this, XiangQingActivity.class);
//                intent.putExtra("pid", bean.getData().get(position).getPid() + "");
                int pid = bean.getData().get(position).getPid();
                EventBus.getDefault().postSticky(new UserEvent(pid + ""));
                startActivity(intent);
            }
        });
    }

    @Override
    public void failuer(String e) {
        Toast.makeText(ListOfDetailsActivity.this, "错误", Toast.LENGTH_SHORT).show();
    }

    private void finishFreshAndLoad() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sv.onFinishFreshAndLoad();
            }
        }, 5000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.dsdsdds();
    }
}
