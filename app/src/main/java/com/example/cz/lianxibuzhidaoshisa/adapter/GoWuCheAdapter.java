package com.example.cz.lianxibuzhidaoshisa.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cz.lianxibuzhidaoshisa.CustRom;
import com.example.cz.lianxibuzhidaoshisa.R;
import com.example.cz.lianxibuzhidaoshisa.bean.GoWuCheBean;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CZ on 2018/1/5.
 */

public class GoWuCheAdapter extends RecyclerView.Adapter<GoWuCheAdapter.MyViewHolder> {
    Context context;
    List<GoWuCheBean.DataBean.ListBean> list;

    private Map<String, String> map = new HashMap<>();

    public GoWuCheAdapter(Context context) {
        this.context = context;
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
    }

    public void add(GoWuCheBean bean) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        for (GoWuCheBean.DataBean shop : bean.getData()) {
            map.put(shop.getSellerid(), shop.getSellerName());
            for (int i = 0; i < shop.getList().size(); i++) {
                this.list.add(shop.getList().get(i));
            }
        }
        setFirst(this.list);
        notifyDataSetChanged();
    }

    public void setFirst(List<GoWuCheBean.DataBean.ListBean> list) {
        if (list.size() > 0) {
            list.get(0).setIsFirst(1);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).getSellerid() == list.get(i - 1).getSellerid()) {
                    list.get(i).setIsFirst(2);
                } else {
                    list.get(i).setIsFirst(1);
                }
            }
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gowucheadapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        //判断显示和隐藏
        if (list.get(position).getIsFirst() == 1) {
            holder.shopCheckbox.setVisibility(View.VISIBLE);
            holder.tvItemShopcartShopname.setVisibility(View.VISIBLE);
            holder.shopCheckbox.setChecked(list.get(position).isShopSelected());
            holder.tvItemShopcartShopname.setText(map.get(String.valueOf(list.get(position).getSellerid())));
        } else {
            //否则隐藏起来
            holder.shopCheckbox.setVisibility(View.GONE);
            holder.tvItemShopcartShopname.setVisibility(View.GONE);
        }
        //点中的商家的控件
        holder.itemCheckbox.setChecked(list.get(position).isItemSelected());

        //把图片数组分割开来，分为一张一张图片
        String[] url = list.get(position).getImages().split("\\|");
        ImageLoader.getInstance().displayImage(url[0], holder.itemPic);
        //商品的标题
        holder.itemName.setText(list.get(position).getTitle());
        //价钱的空件
        holder.itemPrice.setText(list.get(position).getPrice() + "");
        //数量的空件
        holder.plusViewId.setEditText(list.get(position).getNum());
        //商家的点中
        holder.shopCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.get(position).setShopSelected(holder.shopCheckbox.isChecked());
                //循环商品有几件循环几次
                for (int i = 0; i < list.size(); i++) {
                    //判断商品是否全选中，如果选中所有的全选
                    if (list.get(position).getSellerid() == list.get(i).getSellerid()) {
                        list.get(i).setItemSelected(holder.shopCheckbox.isChecked());
                    }
                }
                //刷新适配器
                notifyDataSetChanged();
                //计算总价和输两天
                sum(list);
            }
        });
        //商品的点击事件
        holder.itemCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.get(position).setItemSelected(holder.itemCheckbox.isChecked());
                //循环
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        //判断商品是否点钟
                        if (list.get(i).getSellerid() == list.get(j).getSellerid() && !list.get(j).isItemSelected()) {
                            //未点中
                            list.get(i).setShopSelected(false);
                            break;
                        } else {
                            //否则点钟
                            list.get(i).setShopSelected(true);
                        }
                    }
                    //循环判断后，刷新适配
                    notifyDataSetChanged();
                    //进行计算总价和数量
                    sum(list);
                }
            }
        });
        //删除的点击事件
        holder.itemDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //list删除数据
                list.remove(position);
                setFirst(list);
                //删除完后刷新数据
                notifyDataSetChanged();
                //刷新完数据后进行计算总价和数量
                sum(list);
            }
        });
        holder.plusViewId.setListener(new CustRom.ClickListener() {
            @Override
            public void click(int count) {
                list.get(position).setNum(count);
                //刷新适配器
                notifyDataSetChanged();
                sum(list);
            }
        });


    }

    //这里一定得写，不然会包空指针，这是返回数据
    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    //计算数据
    private void sum(List<GoWuCheBean.DataBean.ListBean> list) {
        int totalNum = 0;
        float totalMoney = 0.0f;
        boolean allCheck = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isItemSelected()) {
                totalNum += list.get(i).getNum();
                totalMoney += list.get(i).getNum() * list.get(i).getPrice();
            } else {
                allCheck = false;
            }
        }
        //list.size()==0?false:allCheck  这是全选后再把数据都删除后，全选按钮还是全选的时候写的
        listener.setToal(totalMoney + "", totalNum + "", list.size() == 0 ? false : allCheck);

    }


    private UpdateUiListener listener;

    public void setListener(UpdateUiListener listener) {
        this.listener = listener;
    }

    public void selectAll(boolean check) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setShopSelected(check);
            list.get(i).setItemSelected(check);
        }
        notifyDataSetChanged();
        sum(list);
    }


    public interface UpdateUiListener {
        public void setToal(String total, String num, boolean allcheck);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.view)
        View view;
        @BindView(R.id.shop_checkbox)
        CheckBox shopCheckbox;
        @BindView(R.id.tv_item_shopcart_shopname)
        TextView tvItemShopcartShopname;
        @BindView(R.id.ll_shopcart_header)
        LinearLayout llShopcartHeader;
        @BindView(R.id.item_checkbox)
        CheckBox itemCheckbox;
        @BindView(R.id.item_pic)
        ImageView itemPic;
        @BindView(R.id.item_price)
        TextView itemPrice;
        @BindView(R.id.item_name)
        TextView itemName;
        @BindView(R.id.tv_item_shopcart_cloth_size)
        TextView tvItemShopcartClothSize;
        @BindView(R.id.plus_view_id)
        CustRom plusViewId;
        @BindView(R.id.item_del)
        ImageView itemDel;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
