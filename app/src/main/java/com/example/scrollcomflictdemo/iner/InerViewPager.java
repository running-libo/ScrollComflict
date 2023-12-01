package com.example.scrollcomflictdemo.iner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 * Created by libo on 2017/12/14.
 */

public class InerViewPager extends ViewPager {
    private int itemCount;

    public InerViewPager(Context context) {
        super(context);
    }

    public InerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                itemCount = getAdapter().getCount();
                if (getCurrentItem() == 0 || getCurrentItem() == itemCount - 1) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

}
