package com.tamplleer.terbat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tamplleer.terbat.MainActivity;

public class Man {
    private int x, y, vx, vy; //координаты в массиве, приращение пути
    private int destinationX, destinationY; // клетка, куда нужно попасть
    private boolean move; // true-идёт или false-стоит человек
    private int steps, stepsTotal; // сделано шагов и общее количество шагов для перехода в др. клетку
    private int direction; // направление 0-север, 1-восток, 2-юг, 3-запад
    public static ImageView image;
    private int picture;
    private int lab[][];
    private int faza;
    int sizeX, sizeY;
    ImageButton red1;
    public static Bitmap imgBitmap[] = new Bitmap[8];
    public Man(MainActivity main){
        this.vx = 0;
        this.vy = 0;
        faza = 0;

        move = false; // пока стоит

        image=new ImageView(main);
        //image.setImageResource(R.drawable.Man);
        sliceAtlas(main);
        image.setImageBitmap(imgBitmap[faza]);
        image.setScaleType(ImageView.ScaleType.FIT_XY); // подгоняет под пропорции Layout, искажая пропорции
        main.addContentView(image, new RelativeLayout.LayoutParams(sizeX,sizeY));
        red1=(ImageButton)main.findViewById(R.id.imb);
       // red1.setImageBitmap(imgBitmap[SP.faza]);
       // move();
    }
    // нарезка атласа
    private void sliceAtlas(MainActivity main){
        Bitmap atlasBitmap = BitmapFactory.decodeResource(main.getResources(), R.drawable.greenatlas);
        int atlasWidth = atlasBitmap.getWidth();
        int atlasHeight = atlasBitmap.getHeight();
        int imgWidth = atlasHeight;
        int imgHeight = atlasHeight;
        int[] pixels = new int[imgWidth * imgHeight];
        for(int i=0; i<8; i++) {
            imgBitmap[i] = Bitmap.createBitmap(imgWidth, imgHeight, Bitmap.Config.ARGB_8888);
            atlasBitmap.getPixels(pixels, 0, imgWidth, imgWidth * i, 0, imgWidth, imgHeight);
            imgBitmap[i].setPixels(pixels, 0, imgWidth, 0, 0, imgWidth, imgHeight);

        }


    }
    // вывод персонажа, когда сделано несколько шагов
    private void outImage(){
        if(steps<8) faza=steps;
        if(steps>=8) faza = 16-steps-1;
        if(faza<0) faza=0;

        image.setImageBitmap(imgBitmap[faza]);
    }// задаём клетку в лабиринте, в которую нужно идти


    // собственно процесс ходьбы
    public void move(){

        faza=SP.faza;
            faza++;
            if(faza >7) faza = 0;
        image.setImageBitmap(imgBitmap[faza]);
        SP.faza=faza;
       // if(image != null) {
     //      image.recycle();
    //        image = null;
       // }
            }

    }// копируем лабиринт в двоичный


