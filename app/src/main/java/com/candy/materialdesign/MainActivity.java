package com.candy.materialdesign;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.candy.materialdesign.adapter.RecyclerAdapter;
import com.candy.materialdesign.listener.OnItemClickListener;
import com.candy.materialdesign.widget.ListDivider;


public class MainActivity extends Activity implements OnItemClickListener {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerView.ItemDecoration itemDecoration;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        //获取RecyclerView对象
        recyclerView = ((RecyclerView) findViewById(R.id.rv));
        //设置线性布局管理器（默认为垂直方向）
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //设置分割线
        itemDecoration = new ListDivider(this);
        recyclerView.addItemDecoration(itemDecoration);
        //配置Adapter
        recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);
        //设置条目点击事件监听器
        recyclerAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this,"点击了第"+position+"个条目",Toast.LENGTH_SHORT).show();
    }
}
