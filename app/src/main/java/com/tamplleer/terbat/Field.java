package com.tamplleer.terbat;

/**
 * Created by h on 04.10.2017.
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Den on 3/11/2017.
 * int bitcoinsPerTime;//How many money  you can get per time
 int opinionChange;// opinion about your inc change + or -;
 int experienceYouGet;// How many ex  you can get  at once
 int dangerLvlChange;
 byte LevelPoint;
 int x,y;
 byte statusPoint;// Has Hacked, is hacking,unavailable,available an smth else
 byte importance;// very Important, middle ,low
 */


public class Field extends MainActivity {


    int x, y;
    Type typeC;
  //  Money money;
   // Dangers dangers;
  //  Influence influence;
    private Bitmap imgBitmap[]=new Bitmap[8];
    private int faza;
    private float scaleX, scaleY;


    boolean statusPoint = false;
    Context context;
    ImageView image;
   int sizeX, sizeY;
    int picture;
    int picture1;
    int myter;
    TextView t1;
    TextView namePoint;
    TextView description1;
    TextView experienceTV;
    TextView bitCoinTV;
    TextView bitCoinPTPTV;
    TextView dangerLvl;
    TextView opinionChange;


    RelativeLayout relativeL1;
    Button buttonOpen;


    public Field(MainActivity main, int x, int y, int type) {
        typeC = new Type();
      //  dangers = new Dangers();
      //  influence = new Influence();
        context = main;
        this.x = x;
        this.y = y;
        this.typeC.type = type;
        //  if (SP.typeCHECK!=1)
        faza=0;
   //     sliceAtlas(main);
       // picture1=typeC.selectBitmapPick(type);
        picture = typeC.selectPictute(type);

//else picture =typeC.spypick(SP.type);
       if (SP.mapLarge==3){sizeY = (main.screenHeight / P.masY)/2+(main.screenHeight / P.masY)/7;
           sizeX = (main.screenWidth / P.masX/2 +(main.screenWidth / P.masX)/(3));}
        else{ sizeY = (main.screenHeight / P.masY)/2+(main.screenHeight / P.masY)/9;
           sizeX = (main.screenWidth / P.masX/2 +(main.screenWidth / (P.masX-1))/3);}
        image = new ImageView(main);
      //  if (type==P.red)
       //     clickSetPic();
      //  else
            image.setImageResource(picture);

        image.setScaleType(ImageView.ScaleType.FIT_XY);
        main.addContentView(image, new RelativeLayout.LayoutParams(sizeX, sizeY));
        SetXY();
        picture = Clickable(type);
      //  buttonOpen = (Button) main.findViewById(R.id.buttonOpen);

     //   relativeL1 = (RelativeLayout) main.findViewById(R.id.relativeL);
        t1 = (TextView) main.findViewById(R.id.text11);
        t1.setText("1");

      //  money = new Money();
      //  xp = new Experience();
      //  selecttypeLou();
       // namePoint = (TextView) main.findViewById(R.id.namePoint);

      //  description1 = (TextView) main.findViewById(R.id.Des);
      //  experienceTV = (TextView) main.findViewById(R.id.experience);
      //  bitCoinTV = (TextView) main.findViewById(R.id.bitCoin);
      //  bitCoinPTPTV = (TextView) main.findViewById(R.id.bitcoinPTPMain);
      //  dangerLvl = (TextView) main.findViewById(R.id.dengerLvl);
      //  opinionChange = (TextView) main.findViewById(R.id.opinion);
        win();
      //  selectAREA();
      //  if (type == 146) area.alpha = 0;
      //  if (type == 193) area.alphaM = 0;
      //  if (type == 168) area.alphaR = 0;
      //  if (type == 178) area.alphaF = 0;


        MyTimer timer1 = new MyTimer();
        timer1.start();





    }

    private void sliceAtlas(MainActivity main){
        Bitmap atlasBitmap= BitmapFactory.decodeResource(main.getResources(),R.drawable.pacmen_atlas);
        int bitmapWidth = atlasBitmap.getWidth();
        int bitmapHight= atlasBitmap.getHeight();
        int imgWidth= bitmapHight;
         int imgHeight = bitmapHight;
        int[] pixels = new int[imgWidth * imgHeight];
       for(int i=0; i<8; i++) {
           imgBitmap[i] = Bitmap.createBitmap(imgWidth, imgHeight, Bitmap.Config.ARGB_8888); // создаём битмап
         //  atlasBitmap.getPixels(pixels, 0, imgWidth, imgWidth * i, 0, imgWidth, imgHeight);// копируем из атласа в буфер
        //   imgBitmap[i].setPixels(pixels, 0, imgWidth, 0, 0, imgWidth, imgHeight); // копируем из буфера в битмап

       }
    }
    public void step(){
        faza++;
        if (faza>7)faza=0;
    }

    public void SetXY() {
        if (SP.mapLarge==3){
        image.setX(x * sizeX +sizeX/2+sizeX);
        image.setY(y * sizeY+sizeY*7);}
        else {
            image.setX(x * sizeX+sizeX/2);
            image.setY(y * sizeY+sizeY*4);}
    }
public void clickSetPic(){
    image.setImageBitmap(Man.imgBitmap[SP.faza]);
}

    private int Clickable(final int type) {

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  image.setImageResource(typeC.selectPictute(map[0][0]));
               //  clickSetPic();

                    t1.setText("" + type);
                    if (type != SP.colorBlock_1 && type != SP.colorBlock_2 && type<10 && type!=SP.colorNOW ){
                    SP.colorNOW=type;
                    SP.click=true;}


/*if (type==1){
    for (int i = 0; i < P.masX; i++)
        for (int j = 0; j < P.masY; j++)
            MainActivity.map[i][j]=2;
}
else for (int i = 0; i < P.masX; i++)
    for (int j = 0; j < P.masY; j++)
        MainActivity.map[i][j]=1;*/
                    SP.type = type;


                    for (int i = 0; i < P.masX; i++)
                        for (int j = 0; j < P.masY; j++)
                            if (map[i][j] == type) {
                                SP.i = i;
                                SP.j = j;
                            }


                    //String des=(typeC.setDescription(type));
                /*    namePoint.setText(typeC.setName(type));
                    description1.setText(typeC.setDescription(type));
                    bitCoinTV.setText("" + money.selectgetBitcoinPlus(type));
                    experienceTV.setText("" + xp.selectXP(type));
                    bitCoinPTPTV.setText("" + money.selectgetBitcoinPTP(type));
                    dangerLvl.setText("" + dangers.selectPoliceDangerPlus(type));
                    opinionChange.setText("" + influence.selectOpinionChange(type));

                    Intent intent = new Intent(context, HackPoint.class);

                    intent.putExtra("Experience", xp.selectXP(type));
                    intent.putExtra("BitCoin", money.selectgetBitcoinPlus(type));
                    intent.putExtra("BitCoinPT", money.selectgetBitcoinPTP(type));
                    intent.putExtra("Danger", dangers.selectPoliceDangerPlus(type));
                    intent.putExtra("Opinion", influence.selectOpinionChange(type));
*/
                /*
                  if ((MainActivity.map[20][6] == 146 && ((type >= 28 && type <= 50) ||
                            (type >= 128 && type <= 150) || (type >= 228 && type <= 250) ||
                            (type >= 428 && type <= 450) || (type >= 328 && type <= 350))) ||
                            (MainActivity.map[8][8] == 168 && ((type >= 64 && type <= 77) ||
                                    (type >= 164 && type <= 177) || (type >= 264 && type <= 277) ||
                                    (type >= 464 && type <= 477) || (type >= 364 && type <= 377))) ||
                            (MainActivity.map[12][10] == 178 && ((type >= 78 && type <= 90) ||
                                    (type >= 178 && type <= 190) || (type >= 278 && type <= 290) ||
                                    (type >= 478 && type <= 490) || (type >= 378 && type <= 390))) ||
                            (MainActivity.map[21][3] == 193 && ((type >= 91 && type <= 99) ||
                                    (type >= 191 && type <= 199) || (type >= 291 && type <= 299) ||
                                    (type >= 491 && type <= 499) || (type >= 391 && type <= 399))) ||
                            (type >= 51 && type <= 63) || (type >= 151 && type <= 163) || (type >= 251 && type <= 263) ||
                            (type >= 3351 && type <= 363) || (type >= 451 && type <= 463) || type == 91 || type == 191 || type == 291 || type == 391 || type == 491 ||

                            type == 46 || type == 68 || type == 78 || type == 93 || type == 246 ||
                            type == 446 || type == 268 || type == 278 || type == 293 || type == 468 ||
                            type == 478 || type == 493 || (type >= 300 && type <= 400)) {
                       // context.startActivity(intent);

                    } else
                        Toast.makeText(context, "This area dont open", Toast.LENGTH_SHORT).show();
*/
                 //   relativeL1.setX(x * sizeX);
                 //   relativeL1.setY(y * sizeY);


                 /*   SP.description = description1.getText().toString();
                    SP.namePoint = namePoint.getText().toString();
                    SP.costHack = money.selectgetBitcoinPlus(type);
                    SP.experiencePLus = xp.selectXP(type);
                    SP.bitCoinPT = money.selectgetBitcoinPTP(type);
                    SP.dangerCNANGE = dangers.selectPoliceDangerPlus(type);
                    SP.opinionCHANGE = influence.selectOpinionChange(type);

                    SP.ddos = typeC.selectddos(type);
                    SP.fishing = typeC.selectfishing(type);
                    SP.spoofing = typeC.selectSpoofing(type);
                    SP.mitm = typeC.selectMITM(type);
                    SP.sniffing = typeC.selectSniffing(type);
                    SP.injection = typeC.selectInjection(type);


                    Log.d("шибка", "CLICK " + SP.money);
                    Log.d("шибка", "PT11 " + SP.moneyPERTIME);
*/
                    //    Toast.makeText(context, selectToast(type),
                    //           Toast.LENGTH_LONG).show();
                    // selecttypeLou();

                }
            });

        //finish();
        return type;

    }


    public void CheckAvailableHack() {

        if (typeC.type == 4) statusPoint = true;
    }

    private int selectToast(int type) {
        switch (type) {
            case 1:
                return R.string.MessageMenu;
            case 2:
                return R.string.MessageMenu1;
            default:
                return R.string.MenuError;
        }
    }

 /* public void selecttypeLou() {
        buttonOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Hack.class);
                context.startActivity(intent);
              /*  if (typeC.type==1 ||typeC.type==2 ||typeC.type==7){
                    typeC.statusPoint=true;
                }
                else Toast.makeText(context, "ER",
                            Toast.LENGTH_LONG).show();*/

        //    }
      //  });
  //  }


    public void win() {
        if (MainActivity.map[14][5] == 128 &&
                MainActivity.map[2][12] == 177 &&
                MainActivity.map[24][1] == 195 &&
                MainActivity.map[21][13] == 183 &&
                MainActivity.map[8][2] == 158) {
            Toast.makeText(context, "WIN",
                    Toast.LENGTH_LONG).show();
        }
    }
   /* public void selectAREA(){
        if (MainActivity.map[8][8]==168)
            SP.research=true;
        if (MainActivity.map[20][6]==146)
            SP.center=true;
        if (MainActivity.map[12][10]==178)
            SP.factory=true;
        if (MainActivity.map[21][3]==193)
            SP.military=true;

    }
    private int Check1(int type){

        if (type==1 || type==3|| type==4|| type==5|| type==8|| type==9|| type==10||type==11){
            image.setImageResource(R.drawable.roadtop111);}
        if (type==2|| type==6||type==7|| type==12) {
            image.setImageResource(R.drawable.roadtop222);
        }
        if ( 63>=type && type>=51 || type==97)
            image.setImageResource(R.drawable.getto11);
        if (50>=type && type>=29)
            image.setImageResource(R.drawable.getto11);
        else image.setImageResource(R.drawable.market11);
        return type;


    }*/
   class MyTimer extends CountDownTimer {
       MainActivity m=new MainActivity();
     //  Man  man= new Man(m);
       MyTimer(){
           super(Integer.MAX_VALUE,100);// продолжительность работы таймера в милисекундах, интервал срабатывания

       }
       @Override
       public  void onTick(long millisUntilFinished){
        //   MainActivity m=new MainActivity();
         //  Man man= new Man(m);
         //    man.move();
           if (SP.colorNOW==16)   clickSetPic(); //если не пауза, то обновляем ERROR!!!!!!!!!!!!!!!!!!!
       }
       @Override
       public  void onFinish(){

       }
   }
}
