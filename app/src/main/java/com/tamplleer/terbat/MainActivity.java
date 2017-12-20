package com.tamplleer.terbat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Matrix;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    public static  String APP_PREFERENCES1 = "mysettings";
    public static  String APP_PREFERENCES_Type="type";
    private SharedPreferences mSettings;
    int bitcoins;//Money which you can use to hack
    int opinion;// opinion about your inc;
    int experience;// ex which you can use to upgrade skills
    int dangerLvl;
    int x,y;
    boolean security= true;


int randomGreat;

    TextView t;

    TextView opinionTV;
    TextView dangerLvlTV;

    TextView cheyTurn;
    TextView score2;
    int screenWidth, screenHeight;

    boolean pause = false;
    static int map[][]= Map.map;
    Field field[][]=new Field[P.masX][P.masY];
   // Money money;
   // Experience xp;
 Bot bot;

   // Area area;
    int rX=0,rY=2000;


    Type typeC;

    public static int progress = 0;
    private ProgressBar pbHorizontal;
    Button red;
    Button blue;
    Button black;
    Button yellow;
    Button purple;
    Button green;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        mSettings = getSharedPreferences(SP.APP_PREFERENCES, Context.MODE_PRIVATE);
       // money=new Money();
       // xp=new Experience();
        typeC=new Type();

        score2=(TextView)findViewById(R.id.score2);
        t = (TextView) findViewById(R.id.text11);
        cheyTurn=(TextView)findViewById(R.id.bitCoinView);
        red=(Button)findViewById(R.id.redBatton);
        black=(Button)findViewById(R.id.blackButton);
        blue=(Button)findViewById(R.id.blueButton);
        yellow=(Button)findViewById(R.id.yellowButton);
        green=(Button)findViewById(R.id.greenButton);
        purple=(Button)findViewById(R.id.purpleButton);


        // pbHorizontal = (ProgressBar) findViewById(R.id.progressBar);
       // postProgress(progress);
       // experienceView=(TextView)findViewById(R.id.ExperienceView);
        //  experienceView.setText(""+SP.experience);
        // SP.experience=xp.experience;

        MyTimer timer = new MyTimer();
        timer.start();
        getScreenSize();
        createFieldRandom();
        //setRL();
       ///////// area=new Area(this);

        // timer.cancel();
        //  if (savedInstanceState != null) {
        // money.allMoney = savedInstanceState.getInt("seconds");

        //}





    }
    public void turn (){}
    public  void  createField() {
        SP.score=0;
        SP.score2=0;
Bot bot= new Bot();
       if (SP.pve==true && SP.pveActive==true && SP.turn==2) {bot.esyBot();}
        Log.d("шибка","color== "+SP.colorNOW);
        for (int i = 0; i < P.masX; i++)
            for (int j = 0; j < P.masY; j++){
                if (SP.turn==1){
                    if (map[i][j]-10 >=1 &&map[i][j]-10 <=10) {
                        if ( j+1<P.masY && i+1<P.masY){
                            if (map[i+1][j]==SP.colorNOW && map[i+1][j]-10 <=0){
                                map[i+1][j]=SP.colorNOW+10;}
                            if (map[i][j+1]==SP.colorNOW && map[i][j+1]-10 <=0){
                                map[i][j+1]=SP.colorNOW+10;
                            }}
                        map[i][j]=SP.colorNOW+10;
                    }}
                if (SP.turn==2){
                    if (SP.pve==true && SP.pveActive==true ){
                        SP.colorNOW=SP.colorNOWbot;}
                    if (map[i][j]-100 >=1) {
                        if ( j+1<P.masY && i+1<P.masY){
                            if (map[i+1][j]==SP.colorNOW && map[i+1][j]-100 <=0){
                                map[i+1][j]=SP.colorNOW+100;
                                Log.d("шибка",SP.score2+"----1");}
                            if (map[i][j+1]==SP.colorNOW && map[i][j+1]-100 <=0){
                                map[i][j+1]=SP.colorNOW+100;
                                Log.d("шибка",SP.score2+"----2");}
                        }
                        map[i][j]=SP.colorNOW+100;
                    }}

                field[i][j] = new Field(this, i, j, map[i][j]);
            }
        for (int i = P.masX-1; i >0; i--)
                for (int j =P.masY-1; j >0; j--){
              if (SP.turn==1){
                  if (map[i][j]-10 >=1 &&map[i][j]-10 <=10) {
                   if ( j-1>-1 && i-1>-1){
                       if (map[i-1][j]==SP.colorNOW && map[i-1][j]-10 <=0){
                           map[i-1][j]=SP.colorNOW+10;}
                       if (map[i][j-1]==SP.colorNOW && map[i][j-1]-10 <=0){
                           map[i][j-1]=SP.colorNOW+10;}}
                   map[i][j]=SP.colorNOW+10;
                   }}
                if (SP.turn==2){
                    if (SP.pve==true  && SP.pveActive==true ){
                        SP.colorNOW=SP.colorNOWbot;}
                    if (map[i][j]-100 >=1) {

                        if ( j-1>-1 && i-1>-1){
                            if (map[i-1][j]==SP.colorNOW && map[i-1][j]-100 <=0){
                                map[i-1][j]=SP.colorNOW+100;
                                Log.d("шибка",SP.score2+"----3");}
                            if (map[i][j-1]==SP.colorNOW && map[i][j-1]-100 <=0){
                                map[i][j-1]=SP.colorNOW+100;
                            Log.d("шибка",SP.score2+"----4");}


                            }
                        map[i][j]=SP.colorNOW+100;
                    }}

                field[i][j] = new Field(this, i, j, map[i][j]);
                    if (SP.colorNOW==16)field[i][j].image.setImageBitmap(Man.imgBitmap[SP.faza]);
            }
        for (int i = 0; i < P.masX; i++)
            for (int j = 0; j < P.masY; j++){
                if (map[i][j]>=10 &&map[i][j]<=20)SP.score++;
                if (map[i][j]>=100)SP.score2++;

            }
        t.setText(""+SP.score);
        score2.setText(""+SP.score2);
        colorBlock();
           win();




  //      if (SP.turn==1 &&  SP.pveActive==true ){SP.turn=2;
 //           createField();}
    }
    public void colorBlock(){
        if (SP.turn==1){
            buttonActive();
            SP.colorBlock_1=SP.colorNOW;
            buttonBlock();}
        if (SP.turn==2){
            buttonActive();
            SP.colorBlock_2=SP.colorNOW;
            buttonBlock();}
    }
    public void buttonBlock(){
switch (SP.colorNOW){
    case 1: black.setEnabled(false);
        black.setAlpha(0.5f);
        break;
    case 2: blue.setEnabled(false);
        blue.setAlpha(0.5f);
        break;
    case 3: red.setEnabled(false);
        red.setAlpha(0.5f);
        break;
    case 4: purple.setEnabled(false);
        purple.setAlpha(0.5f);
        break;
    case 5: yellow.setEnabled(false);
        yellow.setAlpha(0.5f);
        break;
    case 6: green.setEnabled(false);
        green.setAlpha(0.5f);
        break;
    default:t.setText("NO");
        break;

}
        if (SP.colorNOW==1)  black.setEnabled(false);
    }
    public void buttonActive(){
        int active=0;
        if (SP.turn==1)active=SP.colorBlock_1;
        if (SP.turn==2)active=SP.colorBlock_2;
        switch (active){
            case 1: black.setEnabled(true);
                black.setAlpha(1);
                break;
            case 2: blue.setEnabled(true);
                blue.setAlpha(1);
                break;
            case 3: red.setEnabled(true);
                red.setAlpha(1);
                break;
            case 4: purple.setEnabled(true);
                purple.setAlpha(1);
                break;
            case 5: yellow.setEnabled(true);
                yellow.setAlpha(1);
                break;
            case 6: green.setEnabled(true);
                green.setAlpha(1);
                break;
            default:t.setText("figush");
                break;
        }
    }
    private void handler(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                createField();
            }


        },2000);
    }
    public void win() {
            if (SP.score + SP.score2 == 240 ||(SP.score + SP.score2 == 56 &&SP.mapLarge == 1)) {
                if (SP.score > SP.score2) {SP.win=true;
                t.setText("YOU WIN!! on:" + (SP.score - SP.score2));}
                else { SP.win=false;
                    t.setText("YOU LOSE on:" + (SP.score2 - SP.score));}
                Intent intent = new Intent(MainActivity.this,aftergameActivity.class);
                startActivity(intent);
            }
        }

// int pvp, pve; if pvp if pve ezyBot();

    public  void  createFieldRandom() {
        for (int i = 0; i < P.masX; i++)
            for (int j = 0; j < P.masY; j++){
                randomGreat=(int)(Math.random()*100);
                if (randomGreat>=0 && randomGreat<=16)
                    map[i][j]=1;
                if (randomGreat>=16 && randomGreat<=32)
                    map[i][j]=3;
                if (randomGreat>=32 && randomGreat<=48)
                    map[i][j]=4;
                if (randomGreat>=48 && randomGreat<=64)
                    map[i][j]=5;
                if (randomGreat>=64 && randomGreat<=80)
                    map[i][j]=6;
                if (randomGreat>=80 && randomGreat<=100)
                    map[i][j]=2;
               // else map[i][j]=2;
               // map[0][0]+=10;
              //  map[5][5]+=100;
                field[i][j] = new Field(this, i, j, map[i][j]);
                if (map[i][j]>200 && map[i][j]<300){
                    SP.spyI=i;
                    SP.spyJ=j;
                    spyTime();
                }
            }
        map[0][0]+=10;
        map[P.masX-1][P.masY-1]+=100;
        SP.colorNOW= map[P.masX-1][P.masY-1]-100;
        createField();
        SP.colorNOW=map[0][0]-10;
        SP.turn=1;
        createField();
         SP.pveActive=true;
        SP.turn=1;


    }
    public  void spyTime(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                map[SP.spyI][SP.spyJ]+=200;
                field[SP.spyI][SP.spyJ].image.setImageResource(typeC.selectPictute( map[SP.spyI][SP.spyJ]));
                field[SP.spyI][SP.spyJ] = new Field(MainActivity.this, SP.spyI, SP.spyJ, map[SP.spyI][ SP.spyJ]);
                //typeC.selectPictute( map[SP.spyI][SP.spyJ]);
                t.setText("SEND MESSAGE");
            }
        }, 3000);

    }

    public void update(){
       ////// SP.money+=SP.moneyPERTIME;
       ////// bitcoinView.setText(""+ (SP.money));
        //SP.money=money.allMoney;
        if (SP.colorNOW>=0)
       createField();
        Log.d("шибка","++ "+1);



    }
    public void updateTime1(){
      Man man= new Man(this);
    //  man.move();
        if (SP.turn==2 &&  SP.pveActive==true && SP.pve==true ){
            createField();
            SP.turn=1;
            cheyTurn.setText("Твой ход");}
        if (SP.turn==1 &&  SP.click==true  ){
            createField();
            SP.turn=2;
            cheyTurn.setText("Противника ход");
            SP.click=false;}
    }
    protected void getScreenSize(){
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;
    }
   // public void startMoreinfo(View view) {
        //relativeL.setX(300);
        //  relativeL.setY(300);

     //   Intent intent = new Intent(MainActivity.this, Moreinfo.class);
     //   startActivity(intent);



       // save();
     //   if (rX==0 && rY==2000){
      //      rX=200;
      //      rY=200;
     //   }
      //  else {
       ///     rX=0;
      //      rY=2000;
     //   }
      //  relativeL.setX(rX);
     //   relativeL.setY(rY);






   // }
    private void postProgress(int progress) {
        pbHorizontal.setProgress(progress);
        if (progress==100)Toast.makeText(MainActivity.this, "YOU LOST",
                Toast.LENGTH_LONG).show();


        if (progress == 0) {
            pbHorizontal.setSecondaryProgress(0);
        } else {
            pbHorizontal.setSecondaryProgress(progress + 5);
        };
    }
    public void exit (View view) {

       // relativeL.setX(0);
        //relativeL.setY(3000);

        Intent intent = new Intent(MainActivity.this, Menu.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Запоминаем данные
        save();

      /*  for (int i = 0; i < masX; i++)
            for (int j = 0; j < masY; j++)
        editor.putInt(APP_PREFERENCES_Type,field[i][j].picture);
       */
    }
    public void save(){
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(SP.APP_PREFERENCES_Score1,SP.score );
        editor.putString(SP.APP_PREFERENCESHP_DES,SP.description);
        String x="";
        for (int i = 0; i < P.masX; i++)
            for (int j = 0; j < P.masY; j++)
                x=""+x+"x"+map[i][j];
        editor.putString(SP.APP_PREFERENCESHP_DES,x);
        Log.d("шибка","Des"+x);
               // editor.putInt(SP.APP_PREFERENCES_MAP,x);
        editor.apply();
        SP.NEWGAME=false;


    }

    @Override
    protected void onResume() {
        String xmap="";
        Log.d("шибка","NEWGAME 1 "+SP.NEWGAME);

        super.onResume();
        if (SP.NEWGAME==false){
      if (mSettings.contains(SP.APP_PREFERENCESHP_DES)) {
            xmap=(mSettings.getString(SP.APP_PREFERENCESHP_DES,"ss"));
            String aCats[] = xmap.split("x");
            int mInt[]=new int[aCats.length];
            for (int i = 1; i < aCats.length; i++)
             mInt[i] = Integer.parseInt(aCats[i]);
            Log.d("шибка","Desssss"+aCats);
            int f=1;
           for (int i = 0; i < P.masX; i++)
                        for (int j = 0; j < P.masY; j++){
                    map[i][j]= mInt[f];

            f++;}
          SP.colorNOW=SP.colorBlock_1;
            createField();
        }
        Log.d("шибка","Desasa 1 "+(mSettings.getString(SP.APP_PREFERENCESHP_DES,"ss")));

     //  if (mSettings.contains(SP.APP_PREFERENCES_Score1)) {
      //      SP.score = mSettings.getInt(SP.APP_PREFERENCES_Score1, 0);
        //    t.setText(""+ SP.score);
     //   }
     //   if (mSettings.contains(SP.APP_PREFERENCES_MAP)) {
      //    if (SP.score>3){ for (int i = 0; i < P.masX; i++)
     //           for (int j = 0; j < P.masY; j++)
       //     map[i][j]=mSettings.getInt(SP.APP_PREFERENCES_MAP,1);
           // createField();
       // }}
    }}

    public void onBlue(View view) {
        SP.colorNOW=P.blue;
        update();
        if (SP.turn==1){
            SP.turn=2;
        cheyTurn.setText("Противника ход");}
        else {SP.turn=1;
        cheyTurn.setText("Твой ход");}

blue.setAlpha(0.5f);
    }

    public void onRed(View view) {
        SP.colorNOW=P.red;
        update();
        if (SP.turn==1){
            SP.turn=2;
            cheyTurn.setText("Противника ход");}
        else {SP.turn=1;
            cheyTurn.setText("Твой ход");}
    }

    public void onYellow(View view) {
        SP.colorNOW=P.yellow;
        update();
        if (SP.turn==1){
            SP.turn=2;
            cheyTurn.setText("Противника ход");}
        else {SP.turn=1;
            cheyTurn.setText("Твой ход");}
    }

    public void onGreen(View view) {
        SP.colorNOW=P.green;
        update();
        if (SP.turn==1){
            SP.turn=2;
            cheyTurn.setText("Противника ход");}
        else {SP.turn=1;
            cheyTurn.setText("Твой ход");}
    }

    public void onBlack(View view) {
        SP.colorNOW=P.black;
        update();
        if (SP.turn==1){
            SP.turn=2;
            cheyTurn.setText("Противника ход");}
        else {SP.turn=1;
            cheyTurn.setText("Твой ход");}

    }
    public void onPurple(View view) {
        SP.colorNOW=P.purple;
        update();
        if (SP.turn==1){
            SP.turn=2;
            cheyTurn.setText("Противника ход");}
        else {SP.turn=1;
            cheyTurn.setText("Твой ход");}
    }

    /* protected void saveActivityPreferences() {
         // Создайте или извлеките объект настроек активности.
         SharedPreferences activityPreferences = getPreferences(MainActivity.MODE_PRIVATE);
         // Извлеките редактор, чтобы изменить Общие настройки.
         SharedPreferences.Editor editor = activityPreferences.edit();
         // Извлеките представление.
         TextView myTextView = (TextView)findViewById(R.id.myTextView);
         // Запишите новые значения примитивных типов в объект Общих настроек.
         editor.putString("currentTextValue", myTextView.getText().toString());
         // Сохраните изменения.
         editor.commit();
     }*/




    class MyTimer extends CountDownTimer{
        MyTimer(){
            super(Integer.MAX_VALUE,1000);// продолжительность работы таймера в милисекундах, интервал срабатывания

        }
        @Override
        public  void onTick(long millisUntilFinished){
            updateTime1(); //если не пауза, то обновляем ERROR!!!!!!!!!!!!!!!!!!!
        }
        @Override
        public  void onFinish(){

        }
    }}


