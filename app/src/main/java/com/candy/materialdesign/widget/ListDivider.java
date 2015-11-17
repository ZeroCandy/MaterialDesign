package com.candy.materialdesign.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * RecyclerView分割线
 * Created by ZeroCandy on 2015/6/23.
 */
public class ListDivider extends RecyclerView.ItemDecoration {
    //分隔条资源属性数组
    private static final int[] ATTRS={android.R.attr.listDivider};
    //分隔条Drawable对象
    private Drawable mDivider;

    /**
     * 构造方法：进行分隔条资源实例化
     * @param context
     */
    public ListDivider(Context context) {
        TypedArray typedArray=context.obtainStyledAttributes(ATTRS);
        mDivider=typedArray.getDrawable(0);
        typedArray.recycle();
    }

    /**
     * 覆写onDrawOver()方法：绘制所有列表项之间的分隔条
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //获取分隔条起始点横坐标（列表项左边）
        int left=parent.getPaddingLeft();
        //获取分隔条终止点横坐标（列表项右边）
        int right=parent.getWidth()-parent.getPaddingRight();
        //获取列表项的总数
        int itemCount=parent.getChildCount();
        //绘制所有列表项之间的分割线
        for(int i=0;i<itemCount;i++){
            //获取当前列表项
            View itemView = parent.getChildAt(i);
            //获取当前列表项布局参数信息
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) itemView.getLayoutParams();
            //计算分隔条左上角的纵坐标（列表项底部相对高度+列表项底部外边距）
            int top = itemView.getBottom()+params.bottomMargin;
            //计算分隔条右下角的纵坐标（左上角纵坐标+分隔条本身的高度）
            int bottom = top + mDivider.getIntrinsicHeight();
            //设置分隔条绘制的位置
            mDivider.setBounds(left,top,right,bottom);
            //绘制当前列表项下方的分隔条
            mDivider.draw(c);
        }
    }
}
