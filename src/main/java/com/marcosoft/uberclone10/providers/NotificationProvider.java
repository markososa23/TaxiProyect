package com.marcosoft.uberclone10.providers;

import com.marcosoft.uberclone10.models.FCMBody;
import com.marcosoft.uberclone10.models.FCMResponse;
import com.marcosoft.uberclone10.retrofit.IFCMApi;
import com.marcosoft.uberclone10.retrofit.RetrofitClient;

import retrofit2.Call;

public class NotificationProvider {

    public NotificationProvider() {
    }
    public Call<FCMResponse> sendNotification(FCMBody body) {
        String url = "https://fcm.googleapis.com";
        return RetrofitClient.getClientObject(url).create(IFCMApi.class).send(body);

    }
/*    public Call<FCMResponse> sendNotification(FCMBody body) {
        String url = "https://fcm.googleapis.com";
        return RetrofitClient.getClientObject(url).create(IFCMApi.class).send(body);
    }*/
}
