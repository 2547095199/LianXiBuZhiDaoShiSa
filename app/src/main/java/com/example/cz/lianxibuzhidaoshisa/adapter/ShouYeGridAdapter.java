package com.example.cz.lianxibuzhidaoshisa.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.cz.lianxibuzhidaoshisa.R;
import com.example.cz.lianxibuzhidaoshisa.bean.ShouYeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by CZ on 2018/1/2.
 */

public class ShouYeGridAdapter extends BaseAdapter {
    Context context;
    List<ShouYeBean.TuijianBean.ListBean> listbean;

    public ShouYeGridAdapter(Context context, List<ShouYeBean.TuijianBean.ListBean> listbean) {
        this.context = context;
        this.listbean = listbean;
    }

    @Override
    public int getCount() {
        return listbean.size();
    }

    @Override
    public Object getItem(int i) {
        return listbean.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder;
        if (view == null) {
            view = View.inflate(context, R.layout.item_shouyegrid, null);
            holder = new MyViewHolder();
            holder.simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.simple);
            holder.title = (TextView) view.findViewById(R.id.title);
            holder.price = (TextView) view.findViewById(R.id.price);
            holder.button = (Button) view.findViewById(R.id.button);
            view.setTag(holder);
        } else {
            holder = (MyViewHolder) view.getTag();
        }
        String[] split = listbean.get(i).getImages().split("\\|");
        holder.simpleDraweeView.setImageURI(Uri.parse(split[0]));
        holder.title.setText(listbean.get(i).getTitle());
        holder.price.setText("￥:" + listbean.get(i).getPrice());

        return view;
    }

    public class MyViewHolder {
        SimpleDraweeView simpleDraweeView;
        TextView title;
        TextView price;
        Button button;
    }
}
