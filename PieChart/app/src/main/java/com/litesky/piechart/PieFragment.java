package com.litesky.piechart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;

/**
 * Created by finefine.com on 2017/9/19.
 */

public class PieFragment extends Fragment {
    private static final String DATA_KEY = "pieFragment";
    private String data;
    private PieChart mChart;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments=getArguments();
        if (arguments != null) {
            data = arguments.getString(DATA_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate=inflater.inflate(R.layout.fragment_pie,null);
        mChart =inflate.findViewById(R.id.pc_chart);
        return mChart;
    }

    public static PieFragment newInstance(String data) {

        Bundle args = new Bundle();
        args.putString(DATA_KEY,data);

        PieFragment fragment = new PieFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
