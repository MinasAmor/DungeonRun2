package com.example.user.afinal;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;

public class Notifications extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{

    Button bNoti;

    //String file_name="";

    int year,month,date,hour,minute,second;
    private Calendar c;

    /* Broadcast Receiver for battery */
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context ctxt, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            if (level<15)
            {

                AlertDialog.Builder adb;
                adb = new AlertDialog.Builder(Notifications.this);
                adb.setCancelable(false);
                adb.setTitle("Battery alert!");
                adb.setMessage("The level of battery under 15%!");
                adb.setIcon(R.drawable.icon2);
                adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog ad = adb.create();
                ad.show();

            }

            //tv.setText("Battery level is: "+String.valueOf(level) + "%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bNoti=findViewById(R.id.bNoti);
        bNoti.setOnClickListener(this);

        /* Broadcast Receiver for battery */
        //tv=findViewById(R.id.textView);
        this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    @Override
    public void onClick(View view) {
        boolean flag =false;
        if (view==bNoti)
        {
            c = Calendar.getInstance();
            year=2019;
            month=6; //May
            date=18;
            hour=8;
            minute=2;
            second=0;

            takeMonthDay();
        }

    }

    private void TakeHourMinute() {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Choose hour and minute");
        TimePicker tp=new TimePicker(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                @Override
                public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                    hour=i;
                    minute=i1;
                }
            });
        }
        adb.setView(tp);
        adb.setPositiveButton("Start service",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent after = new Intent(Notifications.this, MyService.class);

                        PendingIntent afterIntent = PendingIntent.getService(Notifications.this,
                                0, after, 0);


                        AlarmManager alma = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                        c.set(year, month,date,hour,minute, second);

                        alma.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), afterIntent);
                    }
                });
        adb.create().show();

    }

    private void takeMonthDay() {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Choose month and day");
        DatePicker dp=new DatePicker(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dp.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                    year=i;
                    month=i1+1;
                    date=i2;
                }
            });
        }
        adb.setView(dp);
        adb.setPositiveButton("ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TakeHourMinute();
                    }
                });
        adb.create().show();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_page, menu);/*talan problem*/
        // menu.add(0,1,0,"Save all bills");
        menu.add(0,1,0,"Guide");
        menu.add(0,3,0,"Credit");
        menu.add(0,2,0,"Return");



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.back) {
            finish();
        }
*/
        if (id == 1) {
            Intent go=new Intent(this,Guide.class);
            startActivity(go);
        }
        if (id == 3) {
            Intent gotocred=new Intent(this,Credit.class);
            startActivity(gotocred);
        }
        if(id==2)
        {
            Intent returning=new Intent(this,StartPage.class);
            startActivity(returning);
        }


        return super.onOptionsItemSelected(item);
    }

}
