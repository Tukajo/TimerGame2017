package com.example.tjfri.timergame2017.Models;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import com.example.tjfri.timergame2017.R;

import java.util.Random;

/**
 * Created by TJ Frisch on 1/11/2017.
 */

public class ButtonWrapper {
    private Context context;
    private Button button;
    private int CurrentColor;
    private int timeInMs, tickInterval;
    private int numberOfClicks;
    private CountDownTimer timer;

    public ButtonWrapper(Context context,Button button, int timeInMs, int tickInterval) {
        this.context=context;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed();
            }
        });
        this.button = button;
        randomizeBtnColor();
        this.timeInMs = timeInMs;
        this.tickInterval = tickInterval;
        this.timer = new CountDownTimer(timeInMs,tickInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public int getTimeInMs() {
        return timeInMs;
    }

    public void setTimeInMs(int timeInMs) {
        this.timeInMs = timeInMs;
    }

    public int getTickInterval() {
        return tickInterval;
    }

    public void setTickInterval(int tickInterval) {
        this.tickInterval = tickInterval;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public int getCurrentColor() {
        return CurrentColor;
    }

    public void setCurrentColor(int currentColor) {
        CurrentColor = currentColor;
    }

    public CountDownTimer getTimer() {
        return timer;
    }

    public void setTimer(CountDownTimer timer) {
        this.timer = timer;
    }
    public void setText(String text){
        this.button.setText(text);
    }

    public void buttonPressed(){
        numberOfClicks++;
        this.timer.cancel();
        this.timer = new CountDownTimer(timeInMs/numberOfClicks,tickInterval/numberOfClicks) {
            @Override
            public void onTick(long millisUntilFinished) {
                setText(String.valueOf(millisUntilFinished*numberOfClicks/1000));
            }

            @Override
            public void onFinish() {

            }
        }.start();
        randomizeBtnColor();
    }

    public void randomizeBtnColor() {
        Random rColor = new Random();
        setCurrentColor(rColor.nextInt(5));
        switch (getCurrentColor()) {
            //Red
            case 0:
                getButton().setBackgroundResource(R.drawable.red);
                break;
            //Orange
            case 1:
                getButton().setBackgroundResource(R.drawable.orange);
                break;
            //Blue
            case 2:
                getButton().setBackgroundResource(R.drawable.blue);
                break;
            //Green
            case 3:
                getButton().setBackgroundResource(R.drawable.green);
                break;
            //Purple
            case 4:
                getButton().setBackgroundResource(R.drawable.purple);
                break;
        }
    }
}
