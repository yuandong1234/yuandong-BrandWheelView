package com.yuandong.brandviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yuandong.brandviewdemo.moudle.BrandBean;
import com.yuandong.brandviewdemo.widget.brandLooper.CircleIndicator;
import com.yuandong.brandviewdemo.widget.brandLooper.LoopViewPager;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/5 0005.
 */
public class BrandWheelView extends LinearLayout {

    private Context context;

    private LayoutInflater inflater;
    private ArrayList<BrandBean> list;
    private View brandView;//拿到数据后呈现的广告轮滚图
    private View noDataView;//刚开始没有拿到数据的呈现的view
    private LoopViewPager loopViewPager;
    private CircleIndicator indicator;
    private PicAdapter adapter;

    public BrandWheelView(Context context) {
        super(context);
        this.context=context;
        inflater = LayoutInflater.from(context);
        initView();
    }

    public BrandWheelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        inflater = LayoutInflater.from(context);
        initView();
    }

    public BrandWheelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        inflater = LayoutInflater.from(context);
        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {

        //刚开始没有拿到数据，呈现默认的veiw
        noDataView=inflater.inflate(R.layout.layout_no_data_view,null);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        params.gravity= Gravity.CENTER;
        this.addView(noDataView,params);


        brandView = inflater.inflate(R.layout.layout_brand_view, null);
        loopViewPager=(LoopViewPager)brandView.findViewById(R.id.viewpager);
        indicator=(CircleIndicator)brandView.findViewById(R.id.indicator);

    }

    /**
     * 把数据传过来
     * @param list
     */
    public void setData(ArrayList<BrandBean> list){
      this.list=list;
        upDateView();
    }


    /***
     * 刷新view
     */
    private void upDateView(){
        if(list!=null&&list.size()>0){
            //先除去当前的view中的子View
            this.removeAllViews();
            //添加轮播view
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
            this.addView(brandView,params);

            adapter=new PicAdapter(context,list);
            loopViewPager.setAdapter(adapter);
            loopViewPager.setLooperPic(true);
            indicator.setViewPager(loopViewPager);

        }else{
            return;
        }

    }

}
