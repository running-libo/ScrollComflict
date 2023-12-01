package com.example.scrollcomflictdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

public class BannerViewpagerAdapter extends PagerAdapter {
    private Context context;
    private int[] pics;

    public BannerViewpagerAdapter(Context context, int[] pics) {
        this.context = context;
        this.pics = pics;
    }

    @Override
    public int getCount() {
        return pics.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    /**
     * 相当于baseadapter的getview
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        ImageView imageView = new ImageView(context);
        container.addView(imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(pics[position]);

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
