package com.example.tjfri.timergame2017.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.tjfri.timergame2017.Adapters.HighScoreAdapter;
import com.example.tjfri.timergame2017.Models.HighScore;
import com.example.tjfri.timergame2017.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity {
    private RecyclerView scoreList;
    private FirebaseUser user;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private Query mQuery;
    private HighScoreAdapter highScoreAdapter;
    private ArrayList<HighScore> mAdapterItems;
    private ArrayList<String> mAdapterKeys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);



        //Firebase data write

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("Highscore");
            mQuery = myRef.child("HighScores").limitToFirst(10);
       } else {
            //TODO User lost do some logic.
            // No user is signed in
        }
        setUpList();

    }
    private void setupFirebase() {

    }

    private void setUpList() {
        mAdapterItems = new ArrayList<HighScore>();
        mAdapterKeys = new ArrayList<String>();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.highscorelist);
        highScoreAdapter = new HighScoreAdapter(mQuery, HighScore.class, mAdapterItems, mAdapterKeys);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(highScoreAdapter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        highScoreAdapter.destroy();
    }

}
