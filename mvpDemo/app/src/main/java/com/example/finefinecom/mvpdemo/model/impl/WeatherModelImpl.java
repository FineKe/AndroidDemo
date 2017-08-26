package com.example.finefinecom.mvpdemo.model.impl;

import com.example.finefinecom.mvpdemo.model.WeatherModel;

/**
 * Created by finefine.com on 2017/8/26.
 */

public class WeatherModelImpl implements WeatherModel {
    private  String info="hh";
    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String info) {
        this.info=info;
    }
}
