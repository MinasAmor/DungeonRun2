package com.example.user.afinal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity /*implements View.OnClickListener*/{
//Nightmare Forest
AlertDialog.Builder builder1,builder2;
    ImageButton ib1,ib2,ib3,ib4,ib5;
    ImageView iv1;
    //---------movement bools------
    boolean jobb=true;
    boolean bal=false;
    boolean fel=true;
    boolean lent=false;
    boolean event=false;
    //--------movement bools-------
    int []imageViews={R.id.imageView111,R.id.imageView112,R.id.imageView113,R.id.imageView114,R.id.imageView115,R.id.imageView16,R.id.imageView17,
            R.id.imageView21,R.id.imageView22,R.id.imageView23,R.id.imageView24,R.id.imageView25,R.id.imageView26,R.id.imageView27,
            R.id.imageView31,R.id.imageView32,R.id.imageView33,R.id.imageView34,R.id.imageView35,R.id.imageView36,R.id.imageView37,
            R.id.imageView41,R.id.imageView42,R.id.imageView43,R.id.imageView44,R.id.imageView45,R.id.imageView46,R.id.imageView47,
            R.id.imageView51,R.id.imageView52,R.id.imageView53,R.id.imageView54,R.id.imageView55,R.id.imageView56,R.id.imageView57,
            R.id.imageView61,R.id.imageView62,R.id.imageView63,R.id.imageView64,R.id.imageView65,R.id.imageView66,R.id.imageView67,
            R.id.imageView71,R.id.imageView72,R.id.imageView73,R.id.imageView74,R.id.imageView75,R.id.imageView76,R.id.imageView77,
    };
    ImageView[] imvi=new ImageView[49];
    TextView tv1,textViewX,textViewY;
    int x=1;
    int y=1;
    //Item and monster bools----------------------
    boolean shroom=false;
    boolean icesword=false;
    boolean firerune=false;
    boolean holygrenade=false;
    boolean LegendaryTshirt=false;
    boolean monster1=true;   //firedemon
    boolean monster2=true;   //ent
    boolean monster3=true;   //nyuszi
    boolean monster4=true;   //lovas
    boolean monster5=true;   //szfinx
    boolean ancalagon=false;
    //Item and monster bools----------------------
    
    boolean bossdefeated=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewX=findViewById(R.id.textViewX);
        textViewY=findViewById(R.id.textViewY);
        textViewX.setText("X coordinate is:"+x);
        textViewY.setText("Y coordinate is:"+y);

        //terkep--------------------------------------------------------------------
        for(int i=0;i<imvi.length;i++)
        {
                imvi[i]=findViewById(imageViews[i]);
        }

        //KOD-----ELTAKARAS--------------------ELTAKARAS----ELTAKARAS----ELTAKARAS--
        for(int i=0;i<imvi.length;i++)
        {
            imvi[i].setImageResource(R.drawable.felho);
        }
        //terkep---------------------------------------------------------------------

        ib1=findViewById(R.id.ib1);
        //ib1.setOnClickListener(this);
        ib2=findViewById(R.id.ib2);
        //ib2.setOnClickListener(this);
        ib3=findViewById(R.id.ib3);
        //ib3.setOnClickListener(this);
        ib4=findViewById(R.id.ib4);
        //ib4.setOnClickListener(this);
        ib5=findViewById(R.id.ib5);
        //ib5.setOnClickListener(this);
        iv1=findViewById(R.id.iv1);
        tv1=findViewById(R.id.tv1);
        imvi[0].setImageResource(R.drawable.fentjobb);
         builder1= new AlertDialog.Builder(this);
        builder2= new AlertDialog.Builder(this);
        ib1.setVisibility(View.INVISIBLE);
        ib4.setVisibility(View.INVISIBLE);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_page, menu);
       // menu.add(0,1,0,"Save Game");
        menu.add(0,4,0,"Guide");
        menu.add(0,5,0,"Credit");
        menu.add(0,2,0,"Back to the main menu");
        menu.add(0,3,0,"Close");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        /*if(id==1)
        {

        }*/
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


    public void msgleft1(View view){
        x--;
        Game.this.mapmaking();
        textViewX.setText("X coordinate is:"+x);

        if(x==1&&y==4)
        {
            iv1.setImageResource(R.drawable.icesword);
            tv1.setText("An ancient IceSword its might can defeat the FireDemon");
        }
        if(x==2&&y==2)
        {
            if(firerune==false)
            {
                iv1.setImageResource(R.drawable.firerunefinal);
                tv1.setText("A simple FireRune it might be useful (Yeah i know its looks bad but i didnt found better picture)");
            }
        }
        if(x==1&&y==1)
        {
            tv1.setText("The forest entrace.          (Its too late to go back)");
            iv1.setImageResource(R.drawable.nightmareforest);
        }
        if(x==7)
        {
            ib3.setClickable(false);
            //ib3.setImageResource(R.drawable.wall1);
        }
        else{
            ib3.setClickable(true);
        }
        if(x==1)
        {
            ib1.setClickable(false);
            //ib1.setImageResource(R.drawable.wall1);
        }
        else{
            ib1.setClickable(true);
        }


    }
    public void msgright1(View view){
        x++;
        Game.this.mapmaking();
        textViewX.setText("X coordinate is:"+x);

        //tv1.setText("tukitukihehehehehe"+x);
        if(x==4&&y==7)
        {
            if(shroom==false) {
                iv1.setImageResource(R.drawable.nfshrooms);
                tv1.setText("Some glowing shrooms it might be useful");
            }
        }
        if(x==7&&y==3)
        {
            if(LegendaryTshirt==false) {
                //iv1.setImageResource(R.drawable.nfshrooms);
                tv1.setText("A cool shirt-(written:The Legendary T-Shirt)");
                iv1.setImageResource(R.drawable.tshirt);
            }
        }
        if(x==4&&y==1)
        {
            if(monster1==true) {
                iv1.setImageResource(R.drawable.hellsorcerer);
                tv1.setText("One Fire Demon standing on the road");
                ib3.setVisibility(View.INVISIBLE);
            }
            else
            {
                ib3.setVisibility(View.VISIBLE);
            }
        }
        if(x==3&&y==3) {
            if (monster2==true) {
                ib3.setVisibility(View.INVISIBLE);
                iv1.setImageResource(R.drawable.ent1);
                tv1.setText("The ent (he is not fire resistant)");
            }
            else
            {
                ib3.setVisibility(View.VISIBLE);
            }
        }
        if(x==7)
        {
            ib3.setClickable(false);
            //ib3.setImageResource(R.drawable.wall1);
        }
        else{
            ib3.setClickable(true);
        }
        if(x==1)
        {
            ib1.setClickable(false);
            //ib1.setImageResource(R.drawable.wall1);
        }
        else{
            ib1.setClickable(true);
        }


    }
    public void msgup1(View view){
        y++;
        Game.this.mapmaking();
        textViewY.setText("Y coordinate is:"+y);
        if (x == 7 && y == 7) {
            if(!ancalagon) {
                iv1.setImageResource(R.drawable.nifobo);
                tv1.setText("Yes the forest's protector is a dragon and he looks angry...");
                ib5.setImageResource(R.drawable.sword21);
            }
            else
            {
                iv1.setImageResource(R.drawable.ancalagon);
                ib5.setImageResource(R.drawable.sword21);
                tv1.setText("No way you could defeat Ancalagon");
            }

        }
        if(x==6&&y==7)
        {
            tv1.setText("A dead adventurer in a fancy armor but you aren't a grave robber so you leave it there");
        }
        if(x==5&&y==3)
        {
            if(holygrenade==false)
            {
                //iv1.setImageResource(R.drawable.firerunefinal);
                tv1.setText("The Holy Grenade");
                iv1.setImageResource(R.drawable.holygre);
            }
        }
        if(x==5&&y==7)
        {
            if(monster3) {
                iv1.setImageResource(R.drawable.nyuszi);
                tv1.setText("A very angry rabbit (Dont hazard your life against a demon)");
            }
            else
            {
                tv1.setText("A rabbit's fur might be useful.(for slippers)");
            }
        }
        if(y==1)
        {
            ib4.setClickable(false);
            //ib4.setImageResource(R.drawable.wall1);
        }
        else{
            ib4.setClickable(true);
        }
        if(y==7)
        {
            ib2.setClickable(false);
            //ib2.setImageResource(R.drawable.wall1);
        }
        else{
            ib2.setClickable(true);
        }


    }
    public void msgdown1(View view){
        y--;
        Game.this.mapmaking();

        textViewY.setText("Y coordinate is:"+y);
        if(x==1&&y==1)
        {
            tv1.setText("The forest entrace.          (Its too late to go back)");
            iv1.setImageResource(R.drawable.nightmareforest);

        }
        if(x==2&&y==2)
        {
            if(firerune==false)
            {
                iv1.setImageResource(R.drawable.firerunefinal);
                tv1.setText("A simple FireRune it might be useful (Yeah i know its looks bad but i didnt found better picture)");
            }
        }
        if(y==1)
        {
            ib4.setClickable(false);
            //ib4.setImageResource(R.drawable.wall1);
        }
        else{
            ib4.setClickable(true);
        }
        if(y==7)
        {
            ib2.setClickable(false);
            //ib2.setImageResource(R.drawable.wall1);
        }
        else{
            ib2.setClickable(true);
        }



    }
    public void ulti1(View view){
        if(x==2&&y==2)
        {
            if(firerune==false)
            {
                Toast.makeText(this, "You picked up the FireRune", Toast.LENGTH_SHORT).show();
                firerune=true;
            }
            else
            {
                Toast.makeText(this, "Here is no more FireRune", Toast.LENGTH_SHORT).show();
            }

        }
        if(x==1&&y==4)
        {
            if(icesword==false)
            {
                Toast.makeText(this, "You feel pure power when you take it in your hand", Toast.LENGTH_SHORT).show();
                icesword=true;
            }
            else
            {
                Toast.makeText(this, "You found here the ice sword", Toast.LENGTH_SHORT).show();
            }
        }
        if(x==4&&y==1)
        {
            if(monster1==true)
            {
                if(icesword==true)
                {
                    tv1.setText("The Fire Demon is dead so you can go across");
                    monster1=false;
                    ib3.setVisibility(View.VISIBLE);
                }
                else
                {
                    tv1.setText("You are too weak to defeat this Fire Demon");

                }
            }
        }
        if(x==3&&y==3)
        {
            if(monster2==true)
            {
                if(firerune==true)
                {
                    tv1.setText("The ent has benn defeated");
                    Toast.makeText(this, "Nice Job!", Toast.LENGTH_SHORT).show();
                    monster2=false;
                    ib3.setVisibility(View.VISIBLE);
                }
                else{
                    tv1.setText("You cant defeat the ent just with your hands");
                }
            }
        }
        if(x==3&&y==5)
        {

        }
        if(x==5&&y==3)
        {
            if(holygrenade==false)
            {
                Toast.makeText(this, "You put it into your bag.(keep it in secret)", Toast.LENGTH_SHORT).show();
                holygrenade=true;
            }
            else
            {
                Toast.makeText(this, "The Holy Grenade is not respawning item", Toast.LENGTH_SHORT).show();
            }
        }
        if(x==2&&y==7)
        {

        }
        if(x==4&&y==7)
        {
            if(shroom==false)
            {
                Toast.makeText(this, "You successfully harvested the shrooms", Toast.LENGTH_SHORT).show();
                shroom=true;
            }
            else
            {
                Toast.makeText(this, "You dont found more useful shrooms", Toast.LENGTH_SHORT).show();
            }
        }
        if(x==7&&y==3)
        {
            if(LegendaryTshirt==false)
            {
                Toast.makeText(this, "You feel different, a little bit stronger...", Toast.LENGTH_SHORT).show();
                LegendaryTshirt=true;
            }
            else
            {
                Toast.makeText(this, "There is no more Tshirt, and its against the rules to wear more", Toast.LENGTH_SHORT).show();
            }
        }
        if(x==7&&y==5)
        {

        }
        if(x==5&&y==7)
        {
            if(monster3)
            {
                if (holygrenade == true) {
                    tv1.setText("You blow up the rabbit from very far with the HolyGrenade.");
                    monster3=false;
                } else {
                    builder1.setMessage("You Died!(Its just a test version so you can revive(yes like a Phoenix))");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Restart",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();

                                    Intent restart = new Intent(getBaseContext(), Game.class);
                                    startActivity(restart);

                                }
                            });
                    builder1.setNegativeButton(
                            "Revive!",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }
            else
            {
                tv1.setText("You made slippers from this white rabbit(Its seriusly comfortable)");
            }
        }
        if(x==6&&y==3)
        {
            //alert dialog a szfinxhez
        }
        if(x==7&&y==7)
        {
           if(ancalagon==false) {
               if (LegendaryTshirt == true) {
                   bossdefeated = true;
                   builder1.setMessage("In the last moment when the dragon tried to eat you the Legendery T-shirt stabbed him in hearth and the dragon fall into a rabbithole... (I will not be in his place)" +
                           "       Congratulation!        ");
                   builder1.setCancelable(true);
                   builder1.setPositiveButton(
                           "S-cape",
                           new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   dialog.cancel();

                                   Intent WP = new Intent(getBaseContext(), Achievments.class);
                                   WP.putExtra("bossdefe", true);
                                   startActivity(WP);
                               }
                           });
                   builder1.setNegativeButton(
                           "Revive the Dragon(Its a bad idea)",
                           new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   dialog.cancel();
                                   bossdefeated = false;
                                   Toast.makeText(Game.this, "You found a new moster:Ancalagon", Toast.LENGTH_LONG).show();
                                   tv1.setText("The dragon became more stronger" +
                                           "(Undefeatable Strong)");
                                   iv1.setImageResource(R.drawable.ancalagon);
                                   ancalagon=true;
                               }
                           });

                   AlertDialog alert11 = builder1.create();
                   alert11.show();
               }
               else {
                   //tv1.setText("Unfortunately you died,but its a prototype game so you can revive infinity times:)");
                   builder1.setMessage("You Died!");
                   builder1.setCancelable(true);

                   builder1.setPositiveButton(
                           "Restart",
                           new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   dialog.cancel();
                                   Intent restart = new Intent(getBaseContext(), Game.class);
                                   startActivity(restart);
                               }
                           });
                   builder1.setNegativeButton(
                           "Revive!",
                           new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   dialog.cancel();
                               }
                           });
                   AlertDialog alert11 = builder1.create();
                   alert11.show();
               }
           }
           else
           {
               builder2.setMessage("Ancalagon, also known as Ancalagon the Black, was the greatest of all winged dragons. He was bred by Morgoth during the First Age and was the largest dragon to have ever existed in Middle-earth."
               +"       So he killed the character easily");
               builder2.setCancelable(true);

               builder2.setPositiveButton(
                       "Enter to the hell",
                       new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                               dialog.cancel();
                               Intent crdt = new Intent(getBaseContext(), Credit.class);
                               startActivity(crdt);
                           }
                       });
               AlertDialog alert22 = builder2.create();
               alert22.show();
           }

        }

    }
/*
    @Override
    public void onClick(View v) {
        if((v==ib1)||(v==ib2)||(v==ib3)||(v==ib4))
        */
        public void mapmaking()
        {
            //Frissites
            if((x==1&&y==4)||(x==2&&y==2)||(x==3&&y==3)||(x==4&&y==1)||(x==5&&y==3)||(x==4&&y==7)||(x==5&&y==7)||(x==6&&y==7)||(x==7&&y==7)||(x==7&&y==3))
            {
                event=true;
            }
            else
            {
                iv1.setImageResource(R.drawable.nfcrossroad);
                tv1.setText("");
                ib5.setImageResource(R.drawable.foot2);
            }
            //Frissites
            //THE MAP---------THE MAP---------THE MAP---------THE MAP---------THE MAP---------THE MAP---------THE MAP---------THE MAP---------THE MAP---------
            //1.oszlop----------------------------------------------------------1---------------1---------
            if(x==1&&y==1)
            {
                fel=true;
                bal=false;
                lent=false;
                jobb=true;
            }
            if(x==1&&y==2)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.fentlent);
                fel=true;
                bal=false;
                lent=true;
                jobb=false;
            }
            if(x==1&&y==3)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.lentjobb);
                fel=false;
                bal=false;
                lent=true;
                jobb=true;
            }
            if(x==1&&y==4)
            {
                ib5.setImageResource(R.drawable.hand);
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.csakjobb);
                fel=false;
                bal=false;
                lent=false;
                jobb=true;
            }
            if(x==1&&y==5)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.fentjobb);
                fel=true;
                bal=false;
                lent=false;
                jobb=true;
            }
            if(x==1&&y==6)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.fentlent);
                fel=true;
                bal=false;
                lent=true;
                jobb=false;
            }
            if(x==1&&y==7)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.lentjobb);
                fel=false;
                bal=false;
                lent=true;
                jobb=true;
            }
            //2.oszlop-----------------------------------------------------------------2--------------2----
            if(x==2&&y==1)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.baljobb);
                fel=false;
                bal=true;
                lent=false;
                jobb=true;
            }
            if(x==2&&y==2)
            {
                ib5.setImageResource(R.drawable.hand);
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.fentjobb);
                fel=true;
                bal=false;
                lent=false;
                jobb=true;
            }
            if(x==2&&y==3)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.nemfent);
                fel=false;
                bal=true;
                lent=true;
                jobb=true;
            }
            if(x==2&&y==4)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.balfent);
                fel=true;
                bal=true;
                lent=false;
                jobb=false;
            }
            if(x==2&&y==5)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.nemfent);
                fel=false;
                bal=true;
                lent=true;
                jobb=true;
            }
            if(x==2&&y==6)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.fentjobb);
                fel=true;
                bal=false;
                lent=false;
                jobb=true;
            }
            if(x==2&&y==7)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.ballent);
                fel=false;
                bal=true;
                lent=true;
                jobb=false;
            }


            //3.oszlop-----------------------------------------------------------------3--------------3--------
            if(x==3&&y==1)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.nemlent);
                fel=true;
                bal=true;
                lent=false;
                jobb=true;
            }
            if(x==3&&y==2)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.ballent);
                fel=false;
                bal=true;
                lent=true;
                jobb=false;
            }
            if(x==3&&y==3)
            {
                ib5.setImageResource(R.drawable.sword21);
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.baljobb);
                fel=false;
                bal=true;
                lent=false;
                jobb=true;
            }
            if(x==3&&y==4)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.fentjobb);
                fel=true;
                bal=false;
                lent=false;
                jobb=true;
            }
            if(x==3&&y==5)
            {
                ib5.setImageResource(R.drawable.sword21);
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.ballent);
                fel=false;
                bal=true;
                lent=true;
                jobb=false;
            }
            if(x==3&&y==6)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.nemlent);
                fel=true;
                bal=true;
                lent=false;
                jobb=true;
            }
            if(x==3&&y==7)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.lentjobb);
                fel=false;
                bal=false;
                lent=true;
                jobb=true;
            }
            //4.oszlop--------------------------------------------------------------4--------------4------------------
            if(x==4&&y==1)
            {
                ib5.setImageResource(R.drawable.sword21);
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.baljobb);
                fel=false;
                bal=true;
                lent=false;
                jobb=true;
            }
            if(x==4&&y==2)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.fentjobb);
                fel=true;
                bal=false;
                lent=false;
                jobb=true;
            }
            if(x==4&&y==3)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.nemjobb);
                fel=true;
                bal=true;
                lent=true;
                jobb=false;
            }
            if(x==4&&y==4)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.nemfent);
                fel=false;
                bal=true;
                lent=true;
                jobb=true;
            }
            if(x==4&&y==5)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.fentjobb);
                fel=true;
                bal=false;
                lent=false;
                jobb=true;
            }
            if(x==4&&y==6)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.nemfent);
                fel=false;
                bal=true;
                lent=true;
                jobb=true;
            }
            if(x==4&&y==7)
            {
                ib5.setImageResource(R.drawable.hand);
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.csakball);
                fel=false;
                bal=true;
                lent=false;
                jobb=false;
            }
            //5.oszlop-------------------------------------------------------------5-------------5-------------
            if(x==5&&y==1)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.baljobb);
                fel=false;
                bal=true;
                lent=false;
                jobb=true;
            }
            if(x==5&&y==2)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.balfent);
                fel=true;
                bal=true;
                lent=false;
                jobb=false;
            }
            if(x==5&&y==3)
            {
                ib5.setImageResource(R.drawable.hand);
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.csaklent);
                fel=false;
                bal=false;
                lent=true;
                jobb=false;
            }
            if(x==5&&y==4)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.balfent);
                fel=true;
                bal=true;
                lent=false;
                jobb=false;
            }
            if(x==5&&y==5)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.ballent);
                fel=false;
                bal=true;
                lent=true;
                jobb=false;
            }
            if(x==5&&y==6)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.balfent);
                fel=true;
                bal=true;
                lent=false;
                jobb=false;
            }
            if(x==5&&y==7)
            {
                ib5.setImageResource(R.drawable.sword21);
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.csaklent);
                fel=false;
                bal=false;
                lent=true;
                jobb=false;
            }
            //6.oszlop--------------------------------------------------------------6-----------------6-------
            if(x==6&&y==1)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.baljobb);
                fel=false;
                bal=true;
                lent=false;
                jobb=true;
            }
            if(x==6&&y==2)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.fentjobb);
                fel=true;
                bal=false;
                lent=false;
                jobb=true;
            }
            if(x==6&&y==3)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.nemball);
                fel=true;
                bal=false;
                lent=true;
                jobb=true;
            }
            if(x==6&&y==4)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.nemball);
                fel=true;
                bal=false;
                lent=true;
                jobb=true;
            }
            if(x==6&&y==5)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.fentlent);
                fel=true;
                bal=false;
                lent=true;
                jobb=false;
            }
            if(x==6&&y==6)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.nemball);
                fel=true;
                bal=false;
                lent=true;
                jobb=true;
            }
            if(x==6&&y==7)
            {
                ib5.setImageResource(R.drawable.hand);
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.csaklent);
                fel=false;
                bal=false;
                lent=true;
                jobb=false;
            }
            //7.oszlop-------------------------------------------------------------7-----------------7-------------
            if(x==7&&y==1)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.balfent);
                fel=true;
                bal=true;
                lent=false;
                jobb=false;
            }
            if(x==7&&y==2)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.ballent);
                fel=false;
                bal=true;
                lent=true;
                jobb=false;
            }
            if(x==7&&y==3)
            {
                ib5.setImageResource(R.drawable.hand);
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.csakball);
                fel=false;
                bal=true;
                lent=false;
                jobb=false;
            }
            if(x==7&&y==4)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.balfent);
                fel=true;
                bal=true;
                lent=false;
                jobb=false;
            }
            if(x==7&&y==5)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.csaklent);
                fel=false;
                bal=false;
                lent=true;
                jobb=false;
            }
            if(x==7&&y==6)
            {
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.balfent);
                fel=true;
                bal=true;
                lent=false;
                jobb=false;
            }
            if(x==7&&y==7)
            {
                ib5.setImageResource(R.drawable.sword21);
                imvi[(x-1)*7+y-1].setImageResource(R.drawable.csaklent);
                fel=false;
                bal=false;
                lent=true;
                jobb=false;
            }


            /*------------------movement Checks----------*/
            //-----3 possible way-----4 pieces-----
            /*
            if(imvi[(x-1)*7+y-1].getDrawable()==getResources().getDrawable(R.drawable.nemjobb))
            {   fel=true;
                bal=true;
                lent=true;
                jobb=false; }
            if(imvi[(x-1)*7+y-1].getDrawable()==getResources().getDrawable(R.drawable.nemball))
            {   fel=true;
                bal=false;
                lent=true;
                jobb=true; }
            if(imvi[(x-1)*7+y-1].getDrawable()==getResources().getDrawable(R.drawable.nemfent))
            {   fel=false;
                bal=true;
                lent=true;
                jobb=true; }
            if(imvi[(x-1)*7+y-1].getDrawable()==getResources().getDrawable(R.drawable.nemlent))
            {   fel=true;
                bal=true;
                lent=false;
                jobb=true; }
            //-----1 possible way----4 pieces------
            if(imvi[(x-1)*7+y-1].getDrawable()==getResources().getDrawable(R.drawable.csakball))
            {   fel=false;
                bal=true;
                lent=false;
                jobb=false; }
            if(imvi[(x-1)*7+y-1].getDrawable()==getResources().getDrawable(R.drawable.csakjobb))
            {   fel=false;
                bal=false;
                lent=false;
                jobb=true; }
            if(imvi[(x-1)*7+y-1].getDrawable()==getResources().getDrawable(R.drawable.csakfent))
            {   fel=true;
                bal=false;
                lent=false;
                jobb=false; }
            if(imvi[(x-1)*7+y-1].getDrawable()==getResources().getDrawable(R.drawable.csaklent))
            {   fel=false;
                bal=false;
                lent=true;
                jobb=false; }
            //-----2 possible way------6 pieces----
            if(imvi[(x-1)*7+y-1].getDrawable()==getResources().getDrawable(R.drawable.balfent))
            {   fel=true;
                bal=true;
                lent=false;
                jobb=false; }
            if(imvi[(x-1)*7+y-1].getResources().getDrawable()==getResources().getDrawable(R.drawable.ballent))
            {   fel=false;
                bal=true;
                lent=true;
                jobb=false; }
            if(imvi[(x-1)*7+y-1].getDrawable().equals(getResources().getDrawable(R.drawable.baljobb)))
            {   fel=false;
                bal=true;
                lent=false;
                jobb=true;
            tv1.setText("mukodik");}
            if(imvi[(x-1)*7+y-1].getDrawable().equals(getResources().getDrawable(R.drawable.fentlent)))
            {   fel=true;
                bal=false;
                lent=true;
                jobb=false; }
            if(imvi[(x-1)*7+y-1].getDrawable()==getResources().getDrawable(R.drawable.fentjobb))
            //if(imvi[(x-1)*7+y-1]==getDrawable(R.drawable.fentjobb))
            {   fel=true;
                bal=false;
                lent=false;
                jobb=true; }
            if(imvi[(x-1)*7+y-1].getDrawable()==getResources().getDrawable(R.drawable.lentjobb))
            {   fel=false;
                bal=false;
                lent=true;
                jobb=true; }
            */
            /*------------------movement Checks----------*/
            /*---------arrow visiblity-------*/
            /*balra nyil*/
            if(!bal/*||getResources().getDrawable(R.drawable.lentjobb)*/)
            { ib1.setVisibility(View.INVISIBLE); }
            else
            { ib1.setVisibility(View.VISIBLE); }
            /*jobbra nyil*/
            if(!jobb)
            { ib3.setVisibility(View.INVISIBLE); }
            else
            { ib3.setVisibility(View.VISIBLE); }
            /*fel nyil*/
            if(!fel)
            { ib2.setVisibility(View.INVISIBLE); }
            else
            { ib2.setVisibility(View.VISIBLE); }
            /*lefele nyil*/
            if(!lent)
            { ib4.setVisibility(View.INVISIBLE); }
            else
            { ib4.setVisibility(View.VISIBLE); }
            /*---------arrow visiblity-------*/
        }
    //}*/
}
