package com.example.finefinecom.retrofitdemo;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by finefine.com on 2017/8/27.
 */

public interface GetRequest_Interface {


    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<Translation> getCall();
}
