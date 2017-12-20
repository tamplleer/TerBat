package com.tamplleer.terbat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import android.view.View;

/**
 * Created by Den on 3/20/2017.
 */

public class DialogInMenu {
    AlertDialog.Builder ad;
    Context context;
    int type;


    public DialogInMenu(Menu menu, int type){

        this.type=type;
        context = menu;

        //"confirm exit";


        ad = new AlertDialog.Builder(context);
        ad.setTitle(selectTitle(type));  // заголовок
        ad.setMessage(selectMessage(type)); // сообщение
        ad.setPositiveButton(R.string.Button1Menu, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(context, "Вы сделали правильный выбор",
                        Toast.LENGTH_LONG).show();
                whatDo();
            }
        });
        ad.setNegativeButton(R.string.Button2Menu, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(context, "Возможно fвы правы", Toast.LENGTH_LONG)
                        .show();
            }
        });
        ad.setCancelable(true);
        ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(context, "Вы ничего не выбрали",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public int selectTitle(int type){
        switch (type) {
            case 1:
                return
                        R.string.TitleMenu;
            case 2:
                return R.string.TitleMenu1;
            default:
                return R.string.MenuError;


        }
    }
    public int selectMessage(int type){
        switch (type){
            case 1:
                return R.string.MessageMenu;
            case 2:
                return R.string.MessageMenu1;
            default:
                return R.string.MenuError;
        }}
    public void whatDo(){
        switch (type){
            case 1:
                SP.NEWGAME=true;
                Log.d("шибка","NEWGAME 1 "+SP.NEWGAME);
                Intent intent = new Intent(context,SelectaLevelActivity.class);
                context.startActivity(intent);
            case 2: System.exit(0);

        }




    }}




