package com.example.tjfri.timergame2017;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playBtn = (Button) findViewById(R.id.playButton);
        playBtn.setBackgroundResource(R.drawable.purple);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Transfer to new game activity.
                Intent myGameTransferIntent = new Intent(getBaseContext(), Gameplay.class);
                startActivity(myGameTransferIntent);
            }
        });
    }
}
