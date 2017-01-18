package com.example.tjfri.timergame2017;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tjfri.timergame2017.Utilities.GameUtilities;

public class LossScreen extends AppCompatActivity {
    private int gameTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loss_screen);
        if(getIntent().getExtras()!=null){
            gameTime = getIntent().getExtras().getInt("Game Time");
        }

        TextView timeText = (TextView) findViewById(R.id.gameTimeTextView);
        timeText.setText("Your time was " + GameUtilities.formatTime(gameTime));

        Button returnToMainMenuBtn = (Button) findViewById(R.id.returnToMainMenuBtn);
        returnToMainMenuBtn.setBackgroundResource(R.drawable.orange);
        returnToMainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMainMenu();
            }
        });

    }

    public void returnToMainMenu(){
        Intent returnToMainMenuIntent = new Intent(getBaseContext(),MainActivity.class);
        startActivity(returnToMainMenuIntent);
    }

    @Override
    public void onBackPressed() {
        returnToMainMenu();
    }

}
