package com.candy.materialdesign;

import com.candy.materialdesign.bean.DataBean;

import java.util.ArrayList;

/**
 * 提供数据的类（数据源）
 * Created by ZeroCandy on 2015/6/23.
 */
public class DataSource {
    public static ArrayList<DataBean> getDatas(int size){
        ArrayList<DataBean> datas=new ArrayList<DataBean>();
        for (int i=0;i<size;i++) {
            datas.add(new DataBean("第"+i+"项目"));
        }
        return datas;
    }
}
