package com.example.user.afinal;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Random;

public class StartPage extends AppCompatActivity {
Button btn1,btn2,btn3,btn4,btn5,achiev;
   private BroadcastReceiver BattInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context ctxt, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            if (level<101)
            {
                String notiTitle="The battery level under 20%!";
                String notiText="To remove swipe right";
                //makeNotification(intent, notiTitle, notiText);
                //public void makeNotification(Intent intent, String notiTitle, String notiText)  {
                PendingIntent contentIntent=PendingIntent.getActivity(StartPage.this,
                        0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                NotificationCompat.Builder builder=new NotificationCompat.Builder(StartPage.this);
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

        };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        achiev=findViewById(R.id.achiev);
        //this.registerReceiver(this.BattInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        /*------rand telefon szam--------
        Random rand = new Random();
        int n1 = rand.nextInt(10);
        int n2 = rand.nextInt(10);
        int n3 = rand.nextInt(10);
        int n4 = rand.nextInt(10);
        int n5 = rand.nextInt(10);
        int n6 = rand.nextInt(10);
        int n7 = rand.nextInt(10);
        */


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_page, menu);
        menu.add(0,4,0,"Make Notofication");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == 4) {
            Intent notification=new Intent(this, Notifications.class);
            startActivity(notification);
        }

        return super.onOptionsItemSelected(item);

    }

    public void msg1(View view){
        //Before
        Intent tp1=new Intent(this,Game.class);
        startActivity(tp1);

        //After
        /*Intent t1=new Intent(this,Gamestart.class);
        startActivity(t1);*/
    }
    public void msg2(View view){
        //"""Uresen maradando reszleg.""""
            Intent t2=new Intent(this,LoadGame.class);
            startActivity(t2);
    }
    public void msg3(View view){
        Intent t3=new Intent(this,Credit.class);
        startActivity(t3);
    }
    public void msg4(View view){
        ActivityCompat.finishAffinity(this);
        //finish();
        //System.exit(1);
        //android.os.Process.killProcess(android.os.Process.myPid());
    }
    public void msg5(View view){
        Intent t5=new Intent(this,Guide.class);
        startActivity(t5);
    }
    public void acchiv(View view){
        Intent achnyit=new Intent(this,Achievments.class);
        achnyit.putExtra("bossdefe", false);
        startActivity(achnyit);
    }
}
