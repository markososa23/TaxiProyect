package com.marcosoft.uberclone10.retrofit;

import com.marcosoft.uberclone10.models.FCMBody;
import com.marcosoft.uberclone10.models.FCMResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMApi {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=" + "AAAAlnsDjU0:APA91bFfUhrkqViJavDtDiBJhvoUey-H6hQFZkwFTnU11yCAzC8ZYGUQkbhmGDbQMlH3xge6SJdVw1p_vQ5_sl7JSOTvaobpWR-YPqxV5ditPlaQmvwaGTb2aCPHPosdxUJIO9Y3xXyM"
            })
    @POST("fcm/body")
    Call<FCMResponse> send(@Body FCMBody body);
}

