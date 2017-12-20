package com.tamplleer.terbat;

/**
 * Created by h on 04.10.2017.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Den on 4/9/2017.
 */

public class Type {
    public static int type;

    Context context;
    boolean statusPoint = false;
    int pointToWin = 0;
    boolean myter;

    public Type() {

    }

    public void win() {
        if (type == 3 && statusPoint == true) pointToWin++;
        if (type == 6 && statusPoint == true) pointToWin++;
        if (type == 7 && statusPoint == true) pointToWin++;
        if (pointToWin == 3) Toast.makeText(context, "WIN",
                Toast.LENGTH_LONG).show();
        Log.d("шибка", "QQQ" + pointToWin);}
public Bitmap selectBitmapPick(int type){
    MyTimer timer1 = new MyTimer();
    timer1.start();
    if  (type==106){return Man.imgBitmap[SP.faza] ;}
    return Man.imgBitmap[SP.faza];
}
    public int selectPictute(int type) {

        if (type==P.black)return R.drawable.piceofbrainb;
        if (type==P.blue){return R.drawable.piceofbrainblue;}
        if (type==P.red){return R.drawable.piceofbrainred;}
        if (type==P.purple){return R.drawable.piceofbrainpur;}
        if (type==P.yellow){return R.drawable.piceofbrainyel;}
        if (type==P.green){return R.drawable.piceofbraingree;}

        if (type==11)return R.drawable.piceofbrainb;
        if (type==12){return R.drawable.piceofbrainblue;}
        if (type==13){return R.drawable.piceofbrainred;}
        if (type==14){return R.drawable.piceofbrainpur;}
        if (type==15){return R.drawable.piceofbrainyel;}
        if (type==16){return R.drawable.piceofbraingree;}

        if (type==101)return R.drawable.piceofbrainb;
        if (type==102){return R.drawable.piceofbrainblue;}
        if (type==103){return R.drawable.piceofbrainred;}
        if (type==104){return R.drawable.piceofbrainpur;}
        if (type==105){return R.drawable.piceofbrainyel;}
        if (type==106){return R.drawable.piceofbraingree;}

        return R.drawable.blacksqr;
    }

    class MyTimer extends CountDownTimer {
        MyTimer(){
            super(Integer.MAX_VALUE,100);// продолжительность работы таймера в милисекундах, интервал срабатывания

        }
        @Override
        public  void onTick(long millisUntilFinished){
            //если не пауза, то обновляем ERROR!!!!!!!!!!!!!!!!!!!
        }
        @Override
        public  void onFinish(){

        }
    }

}