package com.example.cz.lianxibuzhidaoshisa.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cz.lianxibuzhidaoshisa.ListOfDetailsActivity;
import com.example.cz.lianxibuzhidaoshisa.R;
import com.example.cz.lianxibuzhidaoshisa.bean.ListOfDetailsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by CZ on 2018/1/4.
 */

public class ListOfDetailsAdapter extends RecyclerView.Adapter<ListOfDetailsAdapter.MyViewHolder> {
    Context context;
    List<ListOfDetailsBean.DataBean> list;

    public ListOfDetailsAdapter(Context context, List<ListOfDetailsBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_listofdetailsadapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        String[] split = list.get(position).getImages().split("\\|");
        holder.simpleDraweeView.setImageURI(Uri.parse(split[0]));
        holder.title.setText(list.get(position).getTitle());
        holder.price.setText("￥:" + list.get(position).getPrice());
        holder.num.setText("数量是：" + list.get(position).getSalenum());
        if (mOnItemClickListener != null) {
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }


    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simpleDraweeView;
        private final TextView title;
        private final TextView price;
        private final TextView num;

        public MyViewHolder(View view) {
            super(view);
            simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.simple);
            title = (TextView) view.findViewById(R.id.title);
            price = (TextView) view.findViewById(R.id.price);
            num = (TextView) view.findViewById(R.id.num);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
