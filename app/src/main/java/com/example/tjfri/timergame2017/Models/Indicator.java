package com.example.tjfri.timergame2017.Models;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tjfri.timergame2017.R;
import com.example.tjfri.timergame2017.Utilities.GameUtilities;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by TJ Frisch on 1/17/2017.
 */

public class Indicator {
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
        randomizeBarColor();
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

    public void randomizeBarColor(){
        Random rColor = new Random();
        setCurrentColor(rColor.nextInt(5));
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
    }

    public int getGlobalTime() {
        return globalTime;
    }

    public void setGlobalTime(int globalTime) {
        this.globalTime = globalTime;
    }
}
