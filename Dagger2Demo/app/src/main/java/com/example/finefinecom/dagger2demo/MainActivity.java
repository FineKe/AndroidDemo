package com.example.finefinecom.dagger2demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private TextView text;

    @Inject
    DaggerPresenter daggerPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= (TextView) findViewById(R.id.text);
        inject();
        daggerPresenter.showUserName();
    }

    public void showUserName(String name)
    {
        text.setText(name);
    }

    private void inject()
    {
        DaggerActivityComponet.builder().activityModule(new ActivityModule(this))
                .build().inject(this);
    }
}
