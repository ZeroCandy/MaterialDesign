package com.candy.appbarlayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initDatas();
    }

    private void initViews() {
        toolBar = ((Toolbar) findViewById(R.id.tb));
        toolBar.setTitle("AppBarLayout");
        tabLayout = ((TabLayout) findViewById(R.id.tl));
    }

    private void initDatas() {
        for(int i=0;i<3;i++){
            tabLayout.addTab(tabLayout.newTab().setText("TAB"+i));
        }
    }
}
