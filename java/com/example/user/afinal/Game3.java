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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Game3 extends AppCompatActivity {
//Passage to the Hell

    ImageButton ib11,ib12,ib13,ib14,ib15;
    ImageView iv3;
    TextView tv3;
    int x3=1;
    int y3=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ib11=findViewById(R.id.ib11);
        ib12=findViewById(R.id.ib12);
        ib13=findViewById(R.id.ib13);
        ib14=findViewById(R.id.ib14);
        ib15=findViewById(R.id.ib15);
        iv3=findViewById(R.id.iv3);
        tv3=findViewById(R.id.tv3);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_page, menu);
        menu.add(0,1,0,"Save Game");
        menu.add(0,4,0,"Guide");
        menu.add(0,5,0,"Credit");
        menu.add(0,2,0,"Back to the main menu");
        menu.add(0,3,0,"Close");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==1)
        {


        }
        if (id == 2) {
            Intent mainmenu=new Intent(this,StartPage.class);
            startActivity(mainmenu);
        }
        if(id==3)
        {
            finish();
           // System.exit(1);
            //android.os.Process.killProcess(android.os.Process.myPid());
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

}
