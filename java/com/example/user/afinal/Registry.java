package com.example.user.afinal;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registry extends AppCompatActivity {
    AlertDialog.Builder builder2,builder3;
    //AlertDialog.Builder builder3;
Button btn1,btn2;
EditText et3,et4,et5;
String [] datas=new String[3];
SQLiteDatabase sqdb;
DataBase database;
int count=0;
ContentValues cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        et3=findViewById(R.id.et3);
        et4=findViewById(R.id.et4);
        et5=findViewById(R.id.et5);
        builder2= new AlertDialog.Builder(this);
        builder3= new AlertDialog.Builder(this);

        database=new DataBase(this);
        sqdb=database.getWritableDatabase();
        sqdb.close();


    }
    public void msg1(View view){

        boolean b7=false;
        sqdb=database.getWritableDatabase();
        datas[0]=et3.getText().toString();
        datas[1]=et4.getText().toString();
        datas[2]=et5.getText().toString();
        Cursor c=sqdb.query(DataBase.TABLE_NAME,null,null,null,null,null,null);
        int col1=c.getColumnIndex(DataBase.NICKNAME);
        int col2=c.getColumnIndex(DataBase.PASS);
        int col3=c.getColumnIndex(DataBase.FAVCOLOR);
        c.moveToFirst();
        while (!c.isAfterLast())
        {

            count++;

            c.moveToNext();
        }
        if(datas[0].equals("")||datas[1].equals("")||datas[2].equals("")) {
            b7 = true;
            Toast.makeText(this, "At least one field is empty", Toast.LENGTH_SHORT).show();
        }
        if(count!=0)
        {
            c.moveToFirst();
            while (!c.isAfterLast())
            {
                String s1=c.getString(col1);
                String s2=c.getString(col2);
                String s3=c.getString(col3);
                if(s1.equals(datas[0])&&!b7)/*&&s2.equals(datas[1])*/
                {
                    builder2.setMessage("The Username is already taken");
                    builder2.setCancelable(true);

                    builder2.setPositiveButton(
                            "Q-it",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    et3.setText("");
                                    et4.setText("");
                                    //et5.setText("");
                                    dialog.cancel();

                                }
                            });
                    builder2.setNegativeButton(
                        "Doesn't Matter",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                et3.setText("");
                                et4.setText("");
                                //et5.setText("");
                                dialog.cancel();
                            }
                        });

                    AlertDialog alert11 = builder2.create();
                    alert11.show();
                    b7=true;
                }

                if(s3.equals(datas[2])&&!b7)
                {
                    builder3.setMessage("The favorite color is already taken");
                    builder3.setCancelable(true);

                    builder3.setPositiveButton(
                            "Understand...",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    //et3.setText("");
                                    //et4.setText("");
                                    et5.setText("");
                                }
                            });
                    AlertDialog alert13 = builder3.create();
                    alert13.show();
                    b7=true;
                }



                c.moveToNext();
            }
        }


        if(!b7) {
            cv = new ContentValues();
            cv.put(database.NICKNAME, datas[0]);
            cv.put(database.PASS, datas[1]);
            cv.put(database.FAVCOLOR, datas[2]);
            sqdb.insert(database.TABLE_NAME, null, cv);
            sqdb.close();

            et3.setText("");
            et4.setText("");
            et5.setText("");
            Toast.makeText(this, "Registration Done", Toast.LENGTH_SHORT).show();


        }




    }
    public void msg2(View view){
        Intent tback=new Intent(this,Login.class);
        startActivity(tback);
    }

}
