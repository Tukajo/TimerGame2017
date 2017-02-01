package com.example.tjfri.timergame2017.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tjfri.timergame2017.R;
import com.example.tjfri.timergame2017.Utilities.GameUtilities;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

public class LossScreen extends AppCompatActivity {
    private String global_time_key = "game_time", correct_clicks_key = "correct_clicks";
    private int gameTime = 0, correctClicks = 0;
    private FirebaseUser user;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loss_screen);
        if(getIntent().getExtras()!=null){
            gameTime = getIntent().getExtras().getInt(global_time_key);
            correctClicks = getIntent().getExtras().getInt(correct_clicks_key);
        }



        TextView timeText = (TextView) findViewById(R.id.gameTimeTextView);
        timeText.setText("Your time was " + GameUtilities.formatTime(gameTime));

        TextView gaemStatsText = (TextView) findViewById(R.id.gameStatisticsTextView);
        gaemStatsText.setText("Timers that you reset: " +  correctClicks);

        Button returnToMainMenuBtn = (Button) findViewById(R.id.returnToMainMenuBtn);
        returnToMainMenuBtn.setBackgroundResource(R.drawable.orange);
        returnToMainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMainMenu();
            }
        });

        //Firebase data write
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            database = FirebaseDatabase.getInstance();
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.w("DATABASE CHANGED", "Failed to read value.", databaseError.toException());

                }
            });
        } else {
            //TODO User lost do some logic.
            // No user is signed in
        }

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
