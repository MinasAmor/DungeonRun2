package com.example.user.afinal;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.user.afinal.R;

public class MyService extends Service {

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       // throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    public void onCreate() {
        super.onCreate();
        //MediaPlayer mp=MediaPlayer.create(this,R.raw.gudok);
        Toast.makeText(this, "Service starting", Toast.LENGTH_SHORT).show();
      //  mp.setLooping(true);
       // mp.start();

        String notiTitle="Very important notification!";
        String notiText="Check if you need to kill some monster!";
        //Intent intent=new Intent(MyService.this, DoSomething.class);
        Intent intent=new Intent();
        makeNotification(intent, notiTitle, notiText);
    }

    public void makeNotification(Intent intent, String notiTitle, String notiText)  {

        PendingIntent contentIntent=PendingIntent.getActivity(MyService.this,
                0, intent,PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(MyService.this);

        builder.setContentIntent(contentIntent);

        builder.setSmallIcon(R.drawable.icon2);

        builder.setContentTitle(notiTitle);

        builder.setContentText(notiText);

        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.icon2));

        builder.setDefaults(Notification.DEFAULT_SOUND);

        builder.setDefaults(Notification.DEFAULT_VIBRATE);

        builder.setDefaults(Notification.DEFAULT_LIGHTS);

        builder.setWhen(System.currentTimeMillis());

        Notification noti=builder.build();

        NotificationManager notificationManager=
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1, noti);
    }
}
