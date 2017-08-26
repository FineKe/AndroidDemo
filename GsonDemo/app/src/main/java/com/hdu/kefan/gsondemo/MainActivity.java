package com.hdu.kefan.gsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String data="{\"name\"=\"tom\",\"id\"=\"78\"}";
        Gson gson=new Gson();
        Person person=gson.fromJson(data,Person.class);

        System.out.println(person.getId()+person.getName());
    }
}
