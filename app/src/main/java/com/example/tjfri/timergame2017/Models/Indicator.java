package com.example.tjfri.timergame2017.Models;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tjfri.timergame2017.R;
import com.example.tjfri.timergame2017.Utilities.GameUtilities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by TJ Frisch on 1/17/2017.
 */

public class Indicator {
    private int[] colorWeights = new int[5];
    private boolean gameCloseToEnding = false;
    private Context context;
    private TextView indicatorBar;
    private Timer globalTimer;
    private int CurrentColor = 0;
    private int globalTime = 0;
    private Activity activity;
    public Indicator(Activity activity, Context context, TextView indicatorBar) {
        this.context = context;
        this.activity = activity;
        this.indicatorBar = indicatorBar;
        initializeGameTimer();
        selectRandomColor();;
    }

    public void incrementColor(int colorToAddToWeightlist){
        gameCloseToEnding=true;
        colorWeights[colorToAddToWeightlist]++;
    }

    public void decrementColor(int colorToAddToWeightlist){
        //TODO - Figure out whether or not the game is no longer close to ending.
        colorWeights[colorToAddToWeightlist]--;
    }

    public void determineWeightedPick(){
        if(gameCloseToEnding){
            selectRandomColor();
            int[] colorTossUp = new int[2];
            colorTossUp[0] = getCurrentColor();
            colorTossUp[1] = determineMostVitalColor();
            Random flipCoin = new Random();
            int coinToss = flipCoin.nextInt(2);
            setCurrentColor(colorTossUp[coinToss]);
        }else{
            selectRandomColor();
        }

    }

    public int determineMostVitalColor(){
        int vitalityDetermined = 0;
        for(int i = 0; i<(colorWeights.length-1);i++){
            if(colorWeights[i] >= colorWeights[i+1]){
                Log.v("VitalitybyColor", "Color: " + i + " val: " + colorWeights[i]);
                vitalityDetermined = colorWeights[i+1];

            }
        }
        Log.v("Vital:","C-Vital Color: " + vitalityDetermined);
        return vitalityDetermined;

    }


    public void initializeGameTimer(){
        globalTimer = new Timer();
        globalTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        indicatorBar.setText(GameUtilities.formatTime(globalTime));
                        globalTime++;
                    }
                });
            }
        }, 1000, 1000);

    }
    public void selectRandomColor(){
        Random rColor = new Random();
        setCurrentColor(rColor.nextInt(5));
    }

    public void stopGameTimer(){
        globalTimer.cancel();
    }
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public TextView getIndicatorBar() {
        return indicatorBar;
    }

    public void setIndicatorBar(TextView indicatorBar) {
        this.indicatorBar = indicatorBar;
    }

    public int getCurrentColor() {
        return CurrentColor;
    }

    public void setCurrentColor(int currentColor) {
        CurrentColor = currentColor;
        switch (getCurrentColor()) {
            //Red
            case 0:
                indicatorBar.setBackgroundResource(R.drawable.red);
                break;
            //Orange
            case 1:
                indicatorBar.setBackgroundResource(R.drawable.orange);
                break;
            //Blue
            case 2:
                indicatorBar.setBackgroundResource(R.drawable.blue);
                break;
            //Green
            case 3:
                indicatorBar.setBackgroundResource(R.drawable.green);
                break;
            //Purple
            case 4:
                indicatorBar.setBackgroundResource(R.drawable.purple);
                break;
        }
    }

    public int getGlobalTime() {
        return globalTime;
    }

    public void setGlobalTime(int globalTime) {
        this.globalTime = globalTime;
    }
}
