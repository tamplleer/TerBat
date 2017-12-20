package com.tamplleer.terbat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class aftergameActivity extends AppCompatActivity {
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aftergame);
        t = (TextView) findViewById(R.id.w_l_text);
     whattext();
    }

    public void w_l_back_menu(View view) {
        Intent intent = new Intent(aftergameActivity.this,Menu.class);
        startActivity(intent);
        finish();
    }

    public void w_l_return(View view) {
        SP.NEWGAME=true;
        Intent intent = new Intent(aftergameActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void w_l_nextLvl(View view) {
    }
    public void whattext(){
        if (SP.win==true) t.setText("YOU WIN!! on:" + (SP.score - SP.score2));
        else  t.setText("YOU LOSE on:" + (SP.score2 - SP.score));
    }
}
