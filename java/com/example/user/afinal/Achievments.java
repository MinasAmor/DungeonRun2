package com.example.user.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Achievments extends AppCompatActivity {
    Button btnvissza,btnrefresh;
    ImageView achiev1;
    TextView achiev11;
    private boolean b22=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievments);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        achiev1=findViewById(R.id.achiev1);
        achiev11=findViewById(R.id.achiev11);
        btnrefresh=findViewById(R.id.btnrefresh);
        btnvissza=findViewById(R.id.btnvissza);
        b22 = getIntent().getExtras().getBoolean("bossdefe", false);

    }
    public void refresh (View view)
    {

        if(b22) {
            achiev1.setVisibility(View.VISIBLE);
            achiev11.setVisibility(View.VISIBLE);
        }
        else
        {
            Toast.makeText(this, "You dont reached any new achievment", Toast.LENGTH_SHORT).show();
        }
    }
    public void mainmenu(View view)
    {
        Intent mainmenu=new Intent(this,StartPage.class);
        startActivity(mainmenu);
    }

}
