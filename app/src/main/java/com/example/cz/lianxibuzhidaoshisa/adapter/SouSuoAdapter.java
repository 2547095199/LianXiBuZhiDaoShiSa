package com.example.cz.lianxibuzhidaoshisa.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cz.lianxibuzhidaoshisa.R;
import com.example.cz.lianxibuzhidaoshisa.SouSuoActivity;
import com.example.cz.lianxibuzhidaoshisa.bean.SouSuoBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CZ on 2018/1/6.
 */

public class SouSuoAdapter extends RecyclerView.Adapter {
    Context context;
    List<SouSuoBean.DataBean> list;
    boolean flag;


    public SouSuoAdapter(Context context, List<SouSuoBean.DataBean> list, boolean flag) {
        this.flag = flag;
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (flag == true) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_san, null);
            return new MyViewHolder(view);
        } else if (flag == false) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_si, null);
            return new ViewHolder01(view);
        }
        return new MyViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder holder1 = (MyViewHolder) holder;
            holder1.title.setText(list.get(position).getTitle());
            holder1.youhui.setText("优惠价:" + list.get(position).getPrice());
            holder1.price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线（删除线）
            holder1.price.setText("原价：￥" + list.get(position).getBargainPrice());
            String[] split = list.get(position).getImages().split("\\|");
            ((MyViewHolder) holder).image.setImageURI(Uri.parse(split[0]));
        } else if (holder instanceof ViewHolder01) {
            ViewHolder01 holder1 = (ViewHolder01) holder;
            holder1.title1.setText(list.get(position).getTitle());
            holder1.youhui1.setText("优惠价:" + list.get(position).getPrice());
            holder1.price1.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线（删除线）
            holder1.price1.setText("原价：￥" + list.get(position).getBargainPrice());
            String[] split = list.get(position).getImages().split("\\|");
            holder1.image1.setImageURI(Uri.parse(split[0]));
        }

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView image;
        private final TextView title;
        private final TextView price;
        private final TextView youhui;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (SimpleDraweeView) itemView.findViewById(R.id.image1);
            title = (TextView) itemView.findViewById(R.id.title1);
            price = (TextView) itemView.findViewById(R.id.price1);
            youhui = (TextView) itemView.findViewById(R.id.youhui1);

        }
    }

    static class ViewHolder01 extends RecyclerView.ViewHolder {

        private final SimpleDraweeView image1;
        private final TextView title1;
        private final TextView price1;
        private final TextView youhui1;

        ViewHolder01(View itemView) {
            super(itemView);
            image1 = (SimpleDraweeView) itemView.findViewById(R.id.image1);
            title1 = (TextView) itemView.findViewById(R.id.title1);
            price1 = (TextView) itemView.findViewById(R.id.price1);
            youhui1 = (TextView) itemView.findViewById(R.id.youhui1);
        }
    }

}
