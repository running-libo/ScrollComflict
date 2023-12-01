package com.example.scrollcomflictdemo;

import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * Created by libo on 2017/12/1.
 */

public class MyPagerAdapter extends PagerAdapter {
    private List<Fragment> fragmentList;
    private FragmentManager fm;

    public MyPagerAdapter(List<Fragment> fragmentList, FragmentManager fm) {
        this.fragmentList = fragmentList;
        this.fm = fm;
    }

    @Override
    public int getCount() {
        return fragmentList != null && !fragmentList.isEmpty() ? fragmentList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = fragmentList.get(position);
        if (!fragment.isAdded()) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(fragment, fragment.getClass().getName());
            //插队
            ft.commitAllowingStateLoss();
            fm.executePendingTransactions();
        }

        View view = fragment.getView();
        if (view != null && view.getParent() == null) {
            container.addView(view);
        }
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(fragmentList.get(position).getView());
    }
}