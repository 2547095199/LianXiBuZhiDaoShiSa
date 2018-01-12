package com.example.cz.lianxibuzhidaoshisa.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cz.lianxibuzhidaoshisa.MainActivity;
import com.example.cz.lianxibuzhidaoshisa.R;
import com.example.cz.lianxibuzhidaoshisa.adapter.FenLeiYouAdapter;
import com.example.cz.lianxibuzhidaoshisa.adapter.FenLeiZuoAdapter;
import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiBean;
import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiYouBean;
import com.example.cz.lianxibuzhidaoshisa.persenter.FenLeiYouPersenter;
import com.example.cz.lianxibuzhidaoshisa.persenter.FenLiePersenter;
import com.example.cz.lianxibuzhidaoshisa.view.FenLeiView;
import com.example.cz.lianxibuzhidaoshisa.view.FenLeiYouView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_02 extends Fragment implements FenLeiView, FenLeiYouView {

    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private Unbinder unbinder;
    FenLiePersenter persenter = new FenLiePersenter(this);
    FenLeiYouPersenter persenter1 = new FenLeiYouPersenter(this);
    private View view;
    private FenLeiYouAdapter adapter;
    private int cid = 1;

    public Fragment_02() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_02, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(manager);
        persenter.getData();
        persenter1.getData("1");
    }

    @Override
    public void success(final FenLeiBean bean) {
        Toast.makeText(getActivity(), "正确", Toast.LENGTH_SHORT).show();
        FenLeiZuoAdapter fragAdapter = new FenLeiZuoAdapter(bean.getData(), getContext());
        listview.setAdapter(fragAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), bean.getData().get(i).getName(), Toast.LENGTH_SHORT).show();
                int cid = bean.getData().get(i).getCid();
                persenter1.getData(cid + "");
            }
        });
    }

    @Override
    public void success(FenLeiYouBean bean) {
//        FenLeiYouAdapter adapter = new Fe`nLeiYouAdapter(getActivity(),bean);
        /// Log.i("bean",bean.getData().get(0).getName());

        FenLeiYouAdapter adapter = new FenLeiYouAdapter(getActivity(), bean.getData());
        recyclerview.setAdapter(adapter);
//        Toast.makeText(getContext(), bean.getData().get(0).getName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void failuer(String e) {
        Toast.makeText(getActivity(), "错误" + e, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        persenter1.dsds();
        persenter.dsdsdsd();
    }
}
