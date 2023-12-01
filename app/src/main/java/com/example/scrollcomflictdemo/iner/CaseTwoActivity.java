package com.example.scrollcomflictdemo.iner;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.scrollcomflictdemo.MyPagerAdapter;
import com.example.scrollcomflictdemo.PageFragment;
import com.example.scrollcomflictdemo.R;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

public class CaseTwoActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private String[] topics = new String[]{"推荐","热点","北京","视频","社会","图片"};
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_two);

        init();
    }

    private void init() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager.setOffscreenPageLimit(3);

        for(int i=0;i<topics.length;i++){
            tabLayout.addTab(tabLayout.newTab());
            fragments.add(new PageFragment());
        }
        viewPager.setAdapter(new MyPagerAdapter(fragments,getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        for (int j = 0; j < topics.length; j++) {
            tabLayout.getTabAt(j).setText(topics[j]);
        }
    }
}
