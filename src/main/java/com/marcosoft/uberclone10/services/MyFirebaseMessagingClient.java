package com.marcosoft.uberclone10.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.marcosoft.uberclone10.R;
import com.marcosoft.uberclone10.channel.NotificationHelper;

import java.util.Map;

public class MyFirebaseMessagingClient extends FirebaseMessagingService {

    private static final int NOTIFICATION_CODE = 100;

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        Map<String, String> data = remoteMessage.getData();
        String title = data.get("title");
        String body = data.get("body");

        if (title != null){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                showNotificationApiOreo(title,body);
            }else{
                showNotification(title,body);
            }
        }
    }

    private void showNotification(String title,String body) {
        PendingIntent intent = PendingIntent.getActivity(getBaseContext(),0,new Intent(),PendingIntent.FLAG_ONE_SHOT);
        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationHelper notificationHelper = new NotificationHelper(getBaseContext());
        NotificationCompat.Builder builder = notificationHelper.getNotificationOldAPI(title,body,intent,sound);
        //NotificationCompat.Builder builder = notificationHelper.getNotificationOldAPI(title,body,sound);
        notificationHelper.getManager().notify(1,builder.build());
    }

        @RequiresApi (api= Build.VERSION_CODES.O)
    private void showNotificationApiOreo(String title,String body) {
        PendingIntent intent = PendingIntent.getActivity(getBaseContext(),0,new Intent(),PendingIntent.FLAG_ONE_SHOT);
        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationHelper notificationHelper = new NotificationHelper(getBaseContext());
        NotificationCompat.Builder builder = notificationHelper.getNotificationOldAPI(title,body,intent,sound);
        //Notification.Builder builder = notificationHelper.getNotificationActions(title,body,sound);
        notificationHelper.getManager().notify(1,builder.build());
    }
}