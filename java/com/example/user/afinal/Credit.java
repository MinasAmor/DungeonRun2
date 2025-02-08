package com.example.user.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Credit extends AppCompatActivity {
Button btncredit;
TextView twcredit;
//String textcredit;
InputStream is;
InputStreamReader isr;
BufferedReader br;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        btncredit=findViewById(R.id.btncredit);
        twcredit=findViewById(R.id.twcredit);
        //textcredit=""+getResources().openRawResource(R.raw.credit)+"";
        //twcredit.setText(textcredit);
        is=null;
        is=getResources().openRawResource(R.raw.credit);
        isr=new InputStreamReader(is);
        br=new BufferedReader(isr);
        String temp="",all="";
        try{
            while((temp=br.readLine())!=null)
                all+=temp+"\n";
            twcredit.setText(all);
            is.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
    public void credit(View view)
    {
        Intent returnmain=new Intent(this,StartPage.class);
        startActivity(returnmain);
    }
}
