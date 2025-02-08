package com.example.user.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Game2 extends AppCompatActivity {
//Ancient Temple
    ImageButton ib6,ib7,ib8,ib9,ib10;
    ImageView iv2;
    TextView tv2;
    int x2=1;
    int y2=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ib6=findViewById(R.id.ib6);
        ib7=findViewById(R.id.ib7);
        ib8=findViewById(R.id.ib8);
        ib9=findViewById(R.id.ib9);
        ib10=findViewById(R.id.ib10);
        iv2=findViewById(R.id.iv2);
        tv2=findViewById(R.id.tv2);




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
            //System.exit(1);
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
