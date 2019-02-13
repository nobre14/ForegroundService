package com.example.foregroundservice;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public final static String CHANEL_ID = "exemploServiceChanel";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChanel();
    }

    private void createNotificationChanel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel serviceChanel = new NotificationChannel(
                    CHANEL_ID,
                    "Exemplo de notification chanel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(serviceChanel);
        }
    }
}
