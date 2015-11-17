package com.candy.palettedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mImageView = ((ImageView) findViewById(R.id.iv));
        mTextView = ((TextView) findViewById(R.id.tv));

        //获取资源图片Bitmap对象
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        //同步生成调色板Palette对象
        Palette p=Palette.from(bitmap).generate();
        //根据Bitmap对象获取调色板Builder，设置调色板异步生成监听器（生成调试版对象是耗时操作，因为要去扫描图像的每个像素点）
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            //当调色板生成时回调该方法
            @Override
            public void onGenerated(Palette palette) {
                //获取最多色彩的色板样本对象
                Palette.Swatch swatch=palette.getVibrantSwatch();
                //获取亮色为主的色彩的色板样本对象
                //Palette.Swatch swatch=palette.getLightVibrantSwatch();
                //获取暗色为主的色彩的色板样本对象
                //Palette.Swatch swatch=palette.getDarkVibrantSwatch();
                if(null!=swatch){
                    //获取色板样本上的RGB颜色设置给tv背景色
                    mTextView.setBackgroundColor(swatch.getRgb());
                    //获取Android建议的一个用于任何标题的颜色并设置给tv的文本颜色
                    mTextView.setTextColor(swatch.getTitleTextColor());
                    //获取Android建议的一个用于任何Body的颜色并设置给tv的文本颜色
                    //mTextView.setTextColor(swatch.getBodyTextColor());
                }
            }
        });
    }
}
