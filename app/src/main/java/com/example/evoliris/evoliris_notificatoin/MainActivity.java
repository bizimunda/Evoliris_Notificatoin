package com.example.evoliris.evoliris_notificatoin;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationCompat.Builder builder= new android.support.v7.app.NotificationCompat.Builder(getApplicationContext());
        builder.setSmallIcon(R.drawable.sun);
        builder.setContentTitle(getString(R.string.new_msg));
        builder.setContentText("YOu have received a notification");
        builder.setSound(Settings.System.getUriFor(Settings.System.NOTIFICATION_SOUND));
        builder.setVibrate(new long[]{200,200});
        builder.setContentIntent(PendingIntent.getActivity(
                MainActivity.this,
                1,
                new Intent(MainActivity.this, Main2Activity.class),
                        0));
        Notification n= builder.build();

        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, n);
    }
}
