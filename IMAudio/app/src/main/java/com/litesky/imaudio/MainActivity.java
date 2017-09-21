package com.litesky.imaudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button file;
    private Button type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
    }

    private void initEvents() {
        file.setOnClickListener(this);
        type.setOnClickListener(this);
    }

    private void initViews() {
        file = ((Button) findViewById(R.id.button_file_MainActivity));
        type = ((Button) findViewById(R.id.button_byte_MainActivity));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button_file_MainActivity:
                startActivity(new Intent(this,FileActivity.class));
                break;
            case R.id.button_byte_MainActivity:
                startActivity(new Intent(this,ByteActivity.class));
                break;
        }
    }
}
