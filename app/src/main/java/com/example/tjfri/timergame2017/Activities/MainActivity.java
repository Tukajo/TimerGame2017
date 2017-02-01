package com.example.tjfri.timergame2017.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.tjfri.timergame2017.Models.HighScore;
import com.example.tjfri.timergame2017.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private static String user_uuid;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playBtn = (Button) findViewById(R.id.playButton);
        Button highScoresBtn = (Button) findViewById(R.id.highScoresBtn);
        highScoresBtn.setBackgroundResource(R.drawable.orange);
        playBtn.setBackgroundResource(R.drawable.purple);


        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
        } else {
            //TODO User lost do some logic.
            // No user is signed in
        }

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Transfer to new game activity.
                Intent myGameTransferIntent = new Intent(getBaseContext(), Gameplay.class);
                startActivity(myGameTransferIntent);
            }
        });
        highScoresBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myHighScoreTransferIntent = new Intent(getBaseContext(), HighScoreActivity.class);
                startActivity(myHighScoreTransferIntent);
            }
        });
    }
}
