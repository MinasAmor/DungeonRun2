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

public class LoadGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_page, menu);
        menu.add(0,2,0,"Guide");
        menu.add(0,3,0,"Credit");
        menu.add(0,1,0,"Back");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == 1) {
            Intent retmain=new Intent(this,StartPage.class);
            startActivity(retmain);
        }
        if(id==2)
        {
            Intent toguide=new Intent(this,Guide.class);
            startActivity(toguide);
        }
        if(id==3)
        {
            Intent tocredit=new Intent(this,Credit.class);
            startActivity(tocredit);
        }

        return super.onOptionsItemSelected(item);
    }

}
