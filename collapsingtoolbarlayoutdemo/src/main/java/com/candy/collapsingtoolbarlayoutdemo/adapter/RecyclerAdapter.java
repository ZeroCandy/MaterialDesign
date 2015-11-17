package com.candy.collapsingtoolbarlayoutdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.candy.collapsingtoolbarlayoutdemo.DataSource;
import com.candy.collapsingtoolbarlayoutdemo.R;
import com.candy.collapsingtoolbarlayoutdemo.bean.DataBean;

import java.util.ArrayList;

/**
 * Created by 帅阳 on 2015/8/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private final ArrayList<DataBean> datas= DataSource.getDatas(20);

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DataBean dataBean=datas.get(position);
        holder.tvItem.setText(dataBean.getDateText());
        holder.itemView.setTag(dataBean);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addItem(){
        datas.add(new DataBean("第"+getItemCount()+"项目"));
        notifyItemInserted(getItemCount());
    }

    /**
     * Holder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvItem;

        public ViewHolder(View itemView) {
            super(itemView);
            tvItem = ((TextView) itemView.findViewById(R.id.item_tv));
        }
    }
}

