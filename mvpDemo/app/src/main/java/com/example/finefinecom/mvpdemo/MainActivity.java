package com.example.finefinecom.mvpdemo;

import android.app.ProgressDialog;
import android.drm.ProcessedData;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finefinecom.mvpdemo.R;
import com.example.finefinecom.mvpdemo.presenter.WeatherPresenter;
import com.example.finefinecom.mvpdemo.view.WeatherView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,WeatherView {
    private WeatherPresenter weatherPresenter;
    private Button getWeatherInfo;
    private TextView weatherInfoTextView;
    private ProgressDialog daDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherPresenter=new WeatherPresenter(this);
        initView();
        initEvents();
    }

    private void initView() {
        getWeatherInfo= (Button) findViewById(R.id.button);
        weatherInfoTextView= (TextView) findViewById(R.id.textView);
    }

    private void initEvents() {
        getWeatherInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        weatherPresenter.requestWeatherInfo();
    }

    @Override
    public void updateInfo(final String info) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                weatherInfoTextView.setText(info);
            }
        });
    }

    @Override
    public void showWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (daDialog!=null&&daDialog.isShowing())
                {
                    daDialog.dismiss();
                }
                daDialog=ProgressDialog.show(MainActivity.this," ","正在获取中");
            }
        });

    }

    @Override
    public void dismissWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(daDialog != null && daDialog.isShowing()){
                    daDialog.dismiss();
                }
            }
        });
    }
}
