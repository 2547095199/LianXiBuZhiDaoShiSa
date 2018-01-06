package com.example.cz.lianxibuzhidaoshisa.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cz.lianxibuzhidaoshisa.R;
import com.example.cz.lianxibuzhidaoshisa.adapter.GoWuCheAdapter;
import com.example.cz.lianxibuzhidaoshisa.bean.GoWuCheBean;
import com.example.cz.lianxibuzhidaoshisa.persenter.GoWuChePersenter;
import com.example.cz.lianxibuzhidaoshisa.view.GoWuCheView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_04 extends Fragment implements GoWuCheView {

    GoWuChePersenter persenter = new GoWuChePersenter(this);
    @BindView(R.id.third_allselect)
    CheckBox thirdAllselect;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    @BindView(R.id.third_totalnum)
    TextView thirdTotalnum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;

    //------------------------

    private RecyclerView recyclerview;
    private View view;
    private Unbinder unbinder;
    private GoWuCheAdapter adapter;

    public Fragment_04() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_04, container, false);
        persenter.getData("100", "android");
        recyclerview = (RecyclerView) view.findViewById(R.id.third_recyclerview);

//        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//        recyclerview.setLayoutManager(manager);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(manager);
        adapter = new GoWuCheAdapter(getContext());
        unbinder = ButterKnife.bind(this, view);
        recyclerview.setAdapter(adapter);
        Log.e("数据", adapter.toString());
        //适配器的事件
        adapter.setListener(new GoWuCheAdapter.UpdateUiListener() {
            @Override
            public void setToal(String total, String num, boolean allcheck) {
                thirdAllselect.setChecked(allcheck);
                thirdTotalnum.setText("共" + num + "件商品");
                thirdTotalprice.setText("总价是：" + total);
            }
        });
        return view;
    }

    @Override
    public void success(GoWuCheBean bean) {
        Toast.makeText(getActivity(), bean.getData().get(0).getSellerName() + "", Toast.LENGTH_SHORT).show();
        adapter.add(bean);
    }

    @Override
    public void failuer(String e) {
        Toast.makeText(getActivity(), "错误", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        persenter.dfdfdf();
        unbinder.unbind();
    }

    @OnClick(R.id.third_allselect)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.third_allselect:
                adapter.selectAll(thirdAllselect.isChecked());
                break;
        }
    }
}
