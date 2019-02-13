package com.example.foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import static com.example.foregroundservice.App.CHANEL_ID;

public class ExemploService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("input");

        Intent notificatonIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, notificatonIntent,0 );

        Notification notification = new NotificationCompat.Builder(this, CHANEL_ID)
                .setContentTitle("Exemplo titulo")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_android_white_24dp)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
