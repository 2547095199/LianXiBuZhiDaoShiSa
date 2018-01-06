package com.example.cz.lianxibuzhidaoshisa.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cz.lianxibuzhidaoshisa.ListOfDetailsActivity;
import com.example.cz.lianxibuzhidaoshisa.R;
import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiYouBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by CZ on 2018/1/3.
 */

public class FenLeiYouZiAdapter extends RecyclerView.Adapter<FenLeiYouZiAdapter.MyViewHolder> {
    Context context;
    List<FenLeiYouBean.DataBean.ListBean> list;
    private View view;

    public FenLeiYouZiAdapter(Context context, List<FenLeiYouBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_fenleiyouziadapter, null);
        view = LayoutInflater.from(context).inflate(R.layout.item_fenleiyouziadapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.simpleDraweeView.setImageURI(Uri.parse(list.get(position).getIcon()));
        holder.titfle.setText(list.get(position).getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(context,""+list.get(position).getPscid(),Toast.LENGTH_SHORT).show();
                int pscid = list.get(position).getPscid();
                Intent intent = new Intent(context, ListOfDetailsActivity.class);
                intent.putExtra("pscid", "" + pscid);
                context.startActivity(intent);

            }
        });
    }


    private FenLeiYouAdapter.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(FenLeiYouAdapter.OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simpleDraweeView;
        private final TextView titfle;

        public MyViewHolder(View view) {
            super(view);
            simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.simple_flz);
            titfle = (TextView) view.findViewById(R.id.title);
        }
    }
}
