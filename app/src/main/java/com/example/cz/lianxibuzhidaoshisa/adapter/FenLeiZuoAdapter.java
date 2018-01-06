package com.example.cz.lianxibuzhidaoshisa.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cz.lianxibuzhidaoshisa.R;
import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiBean;

import java.util.List;

/**
 * Created by CZ on 2018/1/3.
 */

public class FenLeiZuoAdapter extends BaseAdapter {
    List<FenLeiBean.DataBean> data;
    Context context;

    public FenLeiZuoAdapter(List<FenLeiBean.DataBean> data, Context context) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = View.inflate(context, R.layout.item_fenleizuoadapter, null);
            holder = new ViewHolder();
            holder.title = (TextView) view.findViewById(R.id.title);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.title.setText(data.get(i).getName());
        return view;
    }

    public class ViewHolder {
        TextView title;
    }
}
