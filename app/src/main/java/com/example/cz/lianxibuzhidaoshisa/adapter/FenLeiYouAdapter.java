package com.example.cz.lianxibuzhidaoshisa.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cz.lianxibuzhidaoshisa.ListOfDetailsActivity;
import com.example.cz.lianxibuzhidaoshisa.R;
import com.example.cz.lianxibuzhidaoshisa.bean.FenLeiYouBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CZ on 2018/1/3.
 */

public class FenLeiYouAdapter extends RecyclerView.Adapter<FenLeiYouAdapter.MyViewHodel> {
    Context context;
    List<FenLeiYouBean.DataBean> list;
    private List<FenLeiYouBean.DataBean.ListBean> list2;

    public FenLeiYouAdapter(Context context, List<FenLeiYouBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void add(FenLeiYouBean bean) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(bean.getData());
        notifyDataSetChanged();
    }

    @Override
    public MyViewHodel onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fenleiyouadapter, null);
//        View view = LayoutInflater.from(context).inflate(R.layout.item_fenleiyouadapter, parent, false);
        return new MyViewHodel(view);
    }

    @Override
    public void onBindViewHolder(MyViewHodel holder, int position) {
        holder.title.setText(list.get(position).getName());
        list2 = this.list.get(position).getList();
        GridLayoutManager manager = new GridLayoutManager(context, 3);
        holder.recycleView.setLayoutManager(manager);
        FenLeiYouZiAdapter adapter = new FenLeiYouZiAdapter(context, list2);
        holder.recycleView.setAdapter(adapter);

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    public class MyViewHodel extends RecyclerView.ViewHolder {

        private final TextView title;
        private final RecyclerView recycleView;

        public MyViewHodel(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.text_viewfl);
            recycleView = (RecyclerView) itemView.findViewById(R.id.recycle_fl);
        }
    }
}
