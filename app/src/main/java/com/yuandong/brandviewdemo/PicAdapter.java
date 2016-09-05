package com.yuandong.brandviewdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yuandong.brandviewdemo.moudle.BrandBean;

import java.util.ArrayList;

public class PicAdapter extends PagerAdapter{

    private Context context;
    private ArrayList<BrandBean> list;

    public PicAdapter(Context context, ArrayList<BrandBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override public int getCount() {
        return list.size()==0?1:list.size();
    }

    @Override public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView((View) object);
    }

    @Override public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommend_page_item, container, false);
        ImageView imageView = (ImageView)view.findViewById(R.id.image);
        TextView textView = (TextView)view.findViewById(R.id.image_desc);
        if(list!=null&&list.size()>0){
            textView.setText(list.get(position).title);
            Glide.with(context).load(list.get(position).url).into(imageView);
        }

//        Bitmap image = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
//        Bitmap newimage = getRoundCornerImage(image,50);
//        ImageView imageView2 = new ImageView(view.getContext());
//        imageView2.setImageBitmap(newimage);
        container.addView(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,list.get(position).title,Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    /**
     * 转化为圆角图片
     * @param bitmap
     * @param roundPixels
     * @return
     */
    public Bitmap getRoundCornerImage(Bitmap bitmap, int roundPixels) {
        Bitmap roundConcerImage = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(roundConcerImage);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, roundPixels, roundPixels, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, null, rect, paint);
        return roundConcerImage;
    }
}
