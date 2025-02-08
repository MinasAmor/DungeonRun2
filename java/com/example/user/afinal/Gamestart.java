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
import android.widget.RadioButton;

public class Gamestart extends AppCompatActivity {
Button btnStart;
RadioButton rb1,rb2,rb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamestart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnStart=findViewById(R.id.btnStart);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_start_page, menu);
        //menu.add(0,1,0,"Save Game");
        menu.add(0,4,0,"Guide");
        menu.add(0,5,0,"Credit");
        menu.add(0,2,0,"Back to the main menu");
        menu.add(0,3,0,"Close");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        /*
        if(id==1)
        {

        }
        */
        if (id == 2) {
            Intent mainmenu=new Intent(this,StartPage.class);
            startActivity(mainmenu);
        }
        if(id==3)
        {
            finish();
        }
        if(id==4)
        {
            Intent toguide=new Intent(this,Guide.class);
            startActivity(toguide);
        }
        if(id==5)
        {
            Intent tocredit=new Intent(this,Credit.class);
            startActivity(tocredit);
        }

        return super.onOptionsItemSelected(item);
    }
    public void msgStart(View view){
        if(rb1.isChecked())
        {
            Intent gs1=new Intent(this,Game.class);
            startActivity(gs1);

        }
        if(rb2.isChecked())
        {
            Intent gs2=new Intent(this,Game2.class);
            startActivity(gs2);
        }
        if(rb3.isChecked())
        {
            Intent gs3=new Intent(this,Game3.class);
            startActivity(gs3);
        }

    }



}
