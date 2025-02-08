package com.example.user.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Guide extends AppCompatActivity {
Button btnBack;
TextView twguide;
//String textguide;
    InputStream is;
    InputStreamReader isr;
    BufferedReader br;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnBack=findViewById(R.id.btnBack);
        twguide=findViewById(R.id.twguide);
        //textguide=""+getResources().openRawResource(R.raw.guide)+"";
        //twguide.setText(textguide);
        is=null;
        is=getResources().openRawResource(R.raw.guide);
        isr=new InputStreamReader(is);
        br=new BufferedReader(isr);
        String temp="",all="";
        try{
            while((temp=br.readLine())!=null)
                all+=temp+"\n";
            twguide.setText(all);
            is.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_page, menu);
        menu.add(0,2,0,"Back to the main menu");
        menu.add(0,3,0,"Exit Game");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == 2) {
            Intent mainmenu=new Intent(this,StartPage.class);
            startActivity(mainmenu);
        }
        if(id==3)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }
    public void msgback(View view){
        Intent backmainmenu=new Intent(this,StartPage.class);
        startActivity(backmainmenu);
    }

}
