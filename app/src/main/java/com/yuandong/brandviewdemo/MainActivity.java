package com.yuandong.brandviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.yuandong.brandviewdemo.moudle.BrandBean;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<BrandBean> list = new ArrayList<>();
    private Handler handler = new Handler();
    private BrandWheelView brandWheelView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brandWheelView = (BrandWheelView) findViewById(R.id.brandWheelView);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initData();
               brandWheelView.setData(list);
            }
        }, 5000);

    }


    private void initData() {
        BrandBean bean1 = new BrandBean();
        bean1.url = "http://b.hiphotos.baidu.com/image/pic/item/d01373f082025aaf95bdf7e4f8edab64034f1a15.jpg";
        bean1.title = "图片1";
        list.add(bean1);
        BrandBean bean2 = new BrandBean();
        bean2.url = "http://g.hiphotos.baidu.com/image/pic/item/6159252dd42a2834da6660c459b5c9ea14cebf39.jpg";
        bean2.title = "图片2";
        list.add(bean2);
        BrandBean bean3 = new BrandBean();
        bean3.url = "http://d.hiphotos.baidu.com/image/pic/item/adaf2edda3cc7cd976427f6c3901213fb80e911c.jpg";
        bean3.title = "图片3";
        list.add(bean3);
        BrandBean bean4 = new BrandBean();
        bean4.url = "http://g.hiphotos.baidu.com/image/pic/item/b3119313b07eca80131de3e6932397dda1448393.jpg";
        bean4.title = "图片4";
        list.add(bean4);
    }
}
