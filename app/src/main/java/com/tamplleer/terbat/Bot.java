package com.tamplleer.terbat;

import android.widget.Toast;

import java.util.Random;

/**
 * Created by h on 29.10.2017.
 */

public class Bot {
    boolean ezyBot=false;
    boolean mediumBot=false;
    boolean HardBot= false;
    MainActivity m;
    int numberClet[]=new int[6];
    int provrkananull=0;
    public void esyBot(){
        for (int i1=0;i1<numberClet.length;i1++){
            SP.colorNOW=(i1+1);
            for (int i = P.masX-1; i >0; i--)
                for (int j =P.masY-1; j >0; j--){
                        if (m.map[i][j]-100 >=1) {
                            if ( j-1>-1 && i-1>-1){
                                if (m.map[i-1][j]==SP.colorNOW && m.map[i-1][j]-100 <=1){
                                   numberClet[i1]++;}
                                if (m.map[i][j-1]==SP.colorNOW && m.map[i][j-1]-100 <=1){
                                    numberClet[i1]++;}
                            }
                        }
            }
            for (int i = 0; i < P.masX; i++)
                for (int j = 0; j < P.masY; j++){
                    if ( m.map[i][j]-100 >=1) {
                    if ( j+1<P.masY && i+1<P.masY){
                        if ( m.map[i+1][j]==SP.colorNOW &&  m.map[i+1][j]-100 <=1){
                            numberClet[i1]++;}
                        if ( m.map[i][j+1]==SP.colorNOW &&  m.map[i][j+1]-100 <=1){
                            numberClet[i1]++;}
                    }

                }}
    }
    bestColor();

    }
     public void bestColor(){
         int maxClet=0;
         int fla[]={1,4,5,6,3,2};
         for (int i = 0; i <numberClet.length; i++){
             if ((i+1)==SP.colorBlock_1 || (i+1)==SP.colorBlock_2) numberClet[i]=0;
         maxClet = Math.max(maxClet,numberClet[i]);
             if (numberClet[0]==0 &&numberClet[1]==0 && numberClet[2]==0&&
                     numberClet[3]==0&& numberClet[4]==0&& numberClet[5]==0)provrkananull++;
                 }
         for (int i = 0; i <numberClet.length; i++){
             if (maxClet==numberClet[i])SP.colorNOWbot=(i+1);
         }
         if (provrkananull==6){
             for (int i = 0; i <numberClet.length; i++){
             if (SP.colorNOWbot==SP.colorBlock_1 || SP.colorNOWbot==SP.colorBlock_2) {
                 SP.colorNOWbot=(i+1);

             }}
         }

}}
