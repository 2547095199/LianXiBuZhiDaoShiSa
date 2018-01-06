package com.example.cz.lianxibuzhidaoshisa.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cz.lianxibuzhidaoshisa.R;
import com.example.cz.lianxibuzhidaoshisa.bean.ShouYeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CZ on 2017/12/29.
 */

public class ShouyeAdapter extends RecyclerView.Adapter<ShouyeAdapter.MyViewHodel> {
    Context context;
    List<ShouYeBean.MiaoshaBean.ListBeanX> list;

    public ShouyeAdapter(Context context, List<ShouYeBean.MiaoshaBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHodel onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shouyeadapter, null);
        return new MyViewHodel(view);
    }

    @Override
    public void onBindViewHolder(MyViewHodel holder, int position) {
        String[] split = list.get(position).getImages().split("\\|");
        holder.simple.setImageURI(Uri.parse(split[0]));
        holder.youhui.setText("￥" + list.get(position).getBargainPrice());
        holder.price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.price.setText("￥" + list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHodel extends RecyclerView.ViewHolder {
        @BindView(R.id.simple)
        SimpleDraweeView simple;
        @BindView(R.id.youhui)
        TextView youhui;
        @BindView(R.id.price)
        TextView price;

        public MyViewHodel(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
