package com.litesky.piechart;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPager hh;

    private String mJson = "[{\"date\":\"2016年5月\",\"obj\":[{\"title\":\"外卖\",\"value\":34}," +
            "{\"title\":\"娱乐\",\"value\":21},{\"title\":\"其他\",\"value\":45}]}," +
            "{\"date\":\"2016年6月\",\"obj\":[{\"title\":\"外卖\",\"value\":32}," +
            "{\"title\":\"娱乐\",\"value\":22},{\"title\":\"其他\",\"value\":42}]}," +
            "{\"date\":\"2016年7月\",\"obj\":[{\"title\":\"外卖\",\"value\":34}," +
            "{\"title\":\"娱乐\",\"value\":123},{\"title\":\"其他\",\"value\":24}]}," +
            "{\"date\":\"2016年8月\",\"obj\":[{\"title\":\"外卖\",\"value\":145}," +
            "{\"title\":\"娱乐\",\"value\":123},{\"title\":\"其他\",\"value\":124}]}]";
    private ArrayList<MonthBean> mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initViews();
    }

    private void initData() {
        Gson gson=new Gson();

        mData = gson.fromJson(mJson,new TypeToken<ArrayList<MonthBean>>(){}.getType());
    }

    private void initViews() {
        viewPager= (ViewPager) findViewById(R.id.main_view_pager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return PieFragment.newInstance(mData.get(position).toString());
            }

            @Override
            public int getCount() {
                return mData.size();
            }
        });
    }
}
