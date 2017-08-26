package com.example.finefinecom.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View view)
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIInterface service = retrofit.create(APIInterface.class);
        Call<TestModel> model = service.repo("Guolei1130");
        model.enqueue(new Callback<TestModel>() {
            @Override
            public void onResponse(Response<TestModel> response, Retrofit retrofit) {
                Log.d("TAG", "onResponse: "+response.body().getLogin());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("TAG", "onFailure: "+t.getMessage());
            }
        });
    }
}
