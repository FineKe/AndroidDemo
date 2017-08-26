package com.example.finefinecom.mvpdemo.presenter;

import com.example.finefinecom.mvpdemo.model.WeatherModel;
import com.example.finefinecom.mvpdemo.model.impl.WeatherModelImpl;
import com.example.finefinecom.mvpdemo.view.WeatherView;

/**
 * Created by finefine.com on 2017/8/26.
 */

public class WeatherPresenter {
    private WeatherModel weatherModel;
    private WeatherView weatherView;


    public WeatherPresenter(WeatherView weatherView) {
        this.weatherView = weatherView;
        weatherModel=new WeatherModelImpl();
    }

    public void requestWeatherInfo()
    {
        getNetWorkInfo();
    }

    private void showWaitingDialog()
    {
        if (weatherView!=null)
        {
            weatherView.showWaitingDialog();;
        }
    }

    private void dissmissWaitingDialog(){
        if (weatherView != null) {
            weatherView.dismissWaitingDialog();
        }
    }


    private void updateWeatherInfo(String info)
    {
        if(weatherView!=null)
        {
            weatherView.updateInfo(info);
        }
    }

    private void saveInfo(String info)
    {
        weatherModel.setInfo(info);
    }


    private String localInfo(){
        return weatherModel.getInfo();
    }


    private void getNetWorkInfo()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //打开等待对话框
                    showWaitingDialog();
                    //模拟网络耗时
                    Thread.sleep(6000);

                    String info = "21度，晴转多云";
                    //保存到Model层
                    saveInfo(info);
                    //从Model层获取数据，为了演示效果，实际开发中根据情况需要。
                    String localinfo = localInfo();

                    //通知View层改变视图
                    updateWeatherInfo(localinfo);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //取消对话框
                    dissmissWaitingDialog();
                }

            }
        }).start();
    }

}
