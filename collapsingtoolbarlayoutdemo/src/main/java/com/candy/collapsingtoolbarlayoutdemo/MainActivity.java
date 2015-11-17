package com.candy.collapsingtoolbarlayoutdemo;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.candy.collapsingtoolbarlayoutdemo.adapter.RecyclerAdapter;

public class MainActivity extends AppCompatActivity {

    private CollapsingToolbarLayout ctl;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        ctl = ((CollapsingToolbarLayout) findViewById(R.id.ctl));
        mToolbar = ((Toolbar) findViewById(R.id.tb));
        mRecyclerView = ((RecyclerView) findViewById(R.id.rv));
        linearLayoutManager = new LinearLayoutManager(this);

        //CollapsingToolbarLayout相关设置
        ctl.setTitle("Cool");
        Palette.from(BitmapFactory.decodeResource(getResources(),R.drawable.banner))
                .generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        Palette.Swatch swatch=palette.getDarkMutedSwatch();
                        //设置在滑动过程中自动变化到图片颜色
                        ctl.setContentScrimColor(swatch.getRgb());
                    }
                });

        //RecyclerView相关设置
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter=new RecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    public void add(View view){
        Snackbar.make(view,"确定添加？",Snackbar.LENGTH_SHORT)
                .setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mAdapter.addItem();
                        mRecyclerView.scrollToPosition(mAdapter.getItemCount()-1);
                    }
                })
                .show();
    }
}
