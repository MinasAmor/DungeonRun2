package com.example.user.afinal;

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

public class Login extends AppCompatActivity {
Button btn1,btn2,btn3;
Button btnadmin;
EditText et1,et2;
    SQLiteDatabase sqdb;
    DataBase database;
    String [] datas=new String[2];
    int count=0;
    AlertDialog.Builder builder4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btnadmin=findViewById(R.id.btnadmin);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        builder4= new AlertDialog.Builder(this);
        database=new DataBase(this);
        sqdb=database.getWritableDatabase();
        sqdb.close();

    }
    public void msg1(View view) {
        boolean b8=false;
        boolean b9=false;
        sqdb=database.getWritableDatabase();
        datas[0]=et1.getText().toString();
        datas[1]=et2.getText().toString();
        if(datas[0].equals("")||datas[1].equals(""))
        {
            b8=true;
        }

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
        if(count!=0&&!b8)
        {
            c.moveToFirst();
            while (!c.isAfterLast())
            {
                String s1=c.getString(col1);
                String s2=c.getString(col2);
                String s3=c.getString(col3);


                if (s1.equals(datas[0]) && s2.equals(datas[1])) {
                    b9=true;
                    Intent t1 = new Intent(this, StartPage.class);
                    startActivity(t1);

                }
                c.moveToNext();
            }
        }
        if(!b9)
        {
            builder4.setMessage("Wrong Username or Password");
            builder4.setCancelable(true);
            builder4.setPositiveButton(
                    "Escape",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            et1.setText("");
                            et2.setText("");
                            dialog.cancel();
                        }
                    });
            AlertDialog alertempty = builder4.create();
            alertempty.show();
        }
        /*else
        {
            builder4.setMessage("Wrong Username or Password");
            builder4.setCancelable(true);
            builder4.setPositiveButton(
                    "Escape",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertempty = builder4.create();
            alertempty.show();
        }*/

    }
    /*-------------Tobbi mellekes gomb ----------*/

    public void toregistry(View view){
        Intent toregistri=new Intent(this,Registry.class);
        startActivity(toregistri);
    }
    public void msg3(View view){
        Toast.makeText(this, "I'm Sorry it's a Fake button", Toast.LENGTH_SHORT).show();
        //finish();
        //System.exit(1);
        //android.os.Process.killProcess(android.os.Process.myPid());
    }
    public void Admin(View view)
    {
        Intent admin = new Intent(this, StartPage.class);
        startActivity(admin);
    }

}
