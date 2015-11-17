package com.candy.materialdesign.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.candy.materialdesign.DataSource;
import com.candy.materialdesign.R;
import com.candy.materialdesign.bean.DataBean;
import com.candy.materialdesign.listener.OnItemClickListener;

import java.util.ArrayList;

/**
 * RecyclerView的适配器
 * Created by ZeroCandy on 2015/6/25.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private static final String TAG="RecyclerAdapter";
    //数据集合
    private final ArrayList<DataBean> datas = DataSource.getDatas(20);
    //条目点击监听器
    private OnItemClickListener listener;

    @Override
    public int getItemCount() {
        return datas.size();
    }

    /**
     * 创建ViewHolder对象
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //以下注释掉的代码使itemView不会撑满整个Item
        //View itemView = View.inflate(parent.getContext(), R.layout.item_recycler, null);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent,false);
        return new ViewHolder(itemView,listener);
    }

    /**
     * 数据绑定（设置数据）
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //获取数据Bean
        final DataBean dataBean = datas.get(position);
        //ViewHolder中控件绑定数据
        holder.tvItem.setText(dataBean.getDateText());
        //ViewHolder中的itemView绑定数据Bean
        holder.itemView.setTag(dataBean);
    }

    /**
     * 设置条目点击监听器
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }

    /**
     * 删除数据（自定义方法）
     *
     * @param position
     */
    public void removeItem(int position) {
        datas.remove(position);
        //通知条目数据被删除或修改
        notifyItemChanged(position);
    }

    /**
     * 增加数据（自定义方法）
     *
     * @param position
     */
    public void addItem(int position) {
        datas.add(new DataBean("新的列表项目"+datas.size()+1));
        //通知条目增加
        notifyItemInserted(position);
    }

    /**
     * Holder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvItem;
        private OnItemClickListener listener;

        public ViewHolder(View itemView,OnItemClickListener listener) {
            super(itemView);//内部存储itemView
            tvItem = ((TextView) itemView.findViewById(R.id.item_tv));
            this.listener=listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.i(TAG,"点击了");
            if(listener!=null){
                listener.onItemClick(v,getAdapterPosition());
            }
        }
    }
}
