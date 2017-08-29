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
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        APIInterface service = retrofit.create(APIInterface.class);
//        Call<TestModel> model = service.repo("Guolei1130");
//        model.enqueue(new Callback<TestModel>() {
//            @Override
//            public void onResponse(Response<TestModel> response, Retrofit retrofit) {
//                Log.d("TAG", "onResponse: "+response.body().getLogin());
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Log.d("TAG", "onFailure: "+t.getMessage());
//            }
//        });

        request();
    }

    public void request()
    {
        //创建retrofit对象
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create()) //设置Gson解析器
                .build();

        //创建网络接口实例
        GetRequest_Interface request_interface=retrofit.create(GetRequest_Interface.class);

        //对发送请求 进行封装
        Call<Translation> call=request_interface.getCall();

        call.enqueue(new Callback<Translation>() {
            //请求成功时回调
            @Override
            public void onResponse(Response<Translation> response, Retrofit retrofit) {
                response.body().show();
            }

            //请求失败时回调
            @Override
            public void onFailure(Throwable t) {
                System.out.println("连接失败");
            }
        });
    }
}
