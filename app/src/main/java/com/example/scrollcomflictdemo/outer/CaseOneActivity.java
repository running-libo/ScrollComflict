package com.example.scrollcomflictdemo.outer;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scrollcomflictdemo.BannerView;
import com.example.scrollcomflictdemo.BannerViewpagerAdapter;
import com.example.scrollcomflictdemo.R;

public class CaseOneActivity extends AppCompatActivity {
    private BannerView bannerView;
    private BannerViewpagerAdapter pagerAdapter;
    private RelativeLayout rlBanner;
    private int[] pics = new int[]{R.mipmap.banner1,R.mipmap.banner2,R.mipmap.banner3,R.mipmap.banner4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_one);

        init();
    }

    private void init() {
        rlBanner = (RelativeLayout) findViewById(R.id.rl_banner);
        pagerAdapter = new BannerViewpagerAdapter(getApplicationContext(),pics);
        bannerView = new BannerView(getApplicationContext(),pics,pagerAdapter,R.layout.customviewpager);
        //将bannerview添加到需引入控件即可
        rlBanner.addView(bannerView.getBannerView());
    }
}
