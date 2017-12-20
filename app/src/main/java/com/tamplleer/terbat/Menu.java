package com.tamplleer.terbat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Menu extends AppCompatActivity {

    private SharedPreferences mSettingsMENU;
    static DialogInMenu dim;
    int typeButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu);
       // mSettingsMENU = getSharedPreferences(SP.APP_PREFERENCES, Context.MODE_PRIVATE);
        dim = new DialogInMenu(this,typeButton);



    }

    public void onStart(View view){
        //SP.money=SP.moneyNULE;
        saveMENU();

        typeButton=1;
        dim = new DialogInMenu(this,typeButton);
        //SP.money=1000;
       // SP.experience=200;
        saveMENU();


        dim.ad.show();



    }
    public void onContinue(View view){

        Intent intent = new Intent(Menu.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void onExit(View view){
        typeButton=2;
        dim = new DialogInMenu(this,typeButton);

        dim.ad.show();
        typeButton=0;
        Log.d("шибка",""+dim.type);

    }
    public void onSettings(View view){

    }
    public void onRecord(View view){

    }
    public void saveMENU(){
//        editor.putInt(SP.APP_PREFERENCES_Money,SP.money );
   //     editor.putInt(SP.APP_PREFERENCES_XP,SP.experience );
   //     editor.apply();

    }


}
