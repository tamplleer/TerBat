package com.tamplleer.terbat;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SelectaLevelActivity extends AppCompatActivity {
    ConstraintLayout select1,select2,select3;
    ToggleButton pvpTgl,pveTgl,smallTgl,bigTgl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecta_level);
        select1=(ConstraintLayout)findViewById(R.id.select1);
        select2=(ConstraintLayout)findViewById(R.id.select2);
        select3=(ConstraintLayout)findViewById(R.id.select3);
        select2.setX(3000);
        select2.setY(3000);
        select3.setX(3000);
        select3.setY(3000);
        pveTgl=(ToggleButton)findViewById(R.id.pve_toggle);
        pvpTgl=(ToggleButton)findViewById(R.id.pvp_toggle);
        smallTgl=(ToggleButton)findViewById(R.id.smallmap_toggle);
        bigTgl=(ToggleButton)findViewById(R.id.bigmap_toggle);
        SP.NEWGAME=true;
        Log.d("шибка","NEWGAME 1 "+SP.NEWGAME);


    }
public void onPvP(View view) {
    boolean on = ((ToggleButton) view).isChecked();
if (on) {
    SP.pvp=true;
    pveTgl.setChecked(false);
    SP.pve=false;
} else {
    SP.pvp=false;
}
}
    public void onPvE(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            SP.pve=true;
            pvpTgl.setChecked(false);
            SP.pvp=false;
        } else {
            SP.pve=false;
        }
    }

    public void StartGame(View view) {
        Intent intent = new Intent(SelectaLevelActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void Exit(View view) {
    }

    public void patient(View view) {
        select3.setX(0);
        select3.setY(0);
        select1.setX(3000);
        select1.setY(3000);
    }

    public void education(View view) {
    }

    public void boss(View view) {
        select2.setX(0);
        select2.setY(0);
        select1.setX(3000);
        select1.setY(3000);
    }

    public void return3 (View view) {
        select1.setX(0);
        select1.setY(0);
        select2.setX(3000);
        select2.setY(3000);
        select3.setX(3000);
        select3.setY(3000);

    }




    public void onBIGmap(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            SP.mapLarge=3;
            smallTgl.setChecked(false);
            P.masX=15;
            P.masY=16;
        } else {
            SP.mapLarge=1;
        }
    }

    public void onSMALLmap(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            SP.mapLarge=1;
            bigTgl.setChecked(false);
            P.masX=7;
            P.masY=8;
        } else {
            SP.mapLarge=3;
        }
    }
}

