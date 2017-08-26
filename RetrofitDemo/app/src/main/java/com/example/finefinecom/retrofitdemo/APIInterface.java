package com.example.finefinecom.retrofitdemo;


import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by finefine.com on 2017/8/7.
 */

public interface APIInterface {

    @GET("/users/{user}")
    Call<TestModel> repo(@Path("user") String user);
}
