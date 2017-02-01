package com.example.tjfri.timergame2017.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.tjfri.timergame2017.Models.ButtonWrapper;
import com.example.tjfri.timergame2017.Models.Indicator;
import com.example.tjfri.timergame2017.R;

import java.util.ArrayList;
import java.util.Random;

public class Gameplay extends AppCompatActivity implements ButtonWrapper.ButtonWrapperListener{
    private String global_time_key = "game_time", correct_clicks_key = "correct_clicks";
    private ArrayList<ButtonWrapper> myButtonsArray = new ArrayList<ButtonWrapper>();
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25;
    private ButtonWrapper button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,button20,button21,button22,button23,button24,button25;
    private TextView indicatorBar;
    private int correctSelections=0;
    private Indicator indicatorBarWrapper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        //Setup indicator bar.
        indicatorBar = (TextView) findViewById(R.id.currentColorBar);
        //Setup Buttons
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn10 = (Button) findViewById(R.id.button10);
        btn11 = (Button) findViewById(R.id.button11);
        btn12 = (Button) findViewById(R.id.button12);
        btn13 = (Button) findViewById(R.id.button13);
        btn14 = (Button) findViewById(R.id.button14);
        btn15 = (Button) findViewById(R.id.button15);
        btn16 = (Button) findViewById(R.id.button16);
        btn17 = (Button) findViewById(R.id.button17);
        btn18 = (Button) findViewById(R.id.button18);
        btn19 = (Button) findViewById(R.id.button19);
        btn20 = (Button) findViewById(R.id.button20);
        btn21 = (Button) findViewById(R.id.button21);
        btn22 = (Button) findViewById(R.id.button22);
        btn23 = (Button) findViewById(R.id.button23);
        btn24 = (Button) findViewById(R.id.button24);
        btn25 = (Button) findViewById(R.id.button25);
        //Create indicator bar object.
        indicatorBarWrapper = new Indicator(this,getApplicationContext(),indicatorBar);

        //Construct wrappers
        button1 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn1,this);
        button2 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn2,this);
        button3 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn3,this);
        button4 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn4,this);
        button5 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn5,this);
        button6 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn6,this);
        button7 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn7,this);
        button8 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn8,this);
        button9 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn9,this);
        button10 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn10,this);
        button11 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn11,this);
        button12 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn12,this);
        button13 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn13,this);
        button14 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn14,this);
        button15 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn15,this);
        button16 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn16,this);
        button17 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn17,this);
        button18 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn18,this);
        button19 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn19,this);
        button20 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn20,this);
        button21 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn21,this);
        button22 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn22,this);
        button23 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn23,this);
        button24 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn24,this);
        button25 = new ButtonWrapper(getApplicationContext(),indicatorBarWrapper,btn25,this);

        myButtonsArray.add(button1);
        myButtonsArray.add(button2);
        myButtonsArray.add(button3);
        myButtonsArray.add(button4);
        myButtonsArray.add(button5);
        myButtonsArray.add(button6);
        myButtonsArray.add(button7);
        myButtonsArray.add(button8);
        myButtonsArray.add(button9);
        myButtonsArray.add(button10);
        myButtonsArray.add(button11);
        myButtonsArray.add(button12);
        myButtonsArray.add(button13);
        myButtonsArray.add(button14);
        myButtonsArray.add(button15);
        myButtonsArray.add(button16);
        myButtonsArray.add(button17);
        myButtonsArray.add(button18);
        myButtonsArray.add(button19);
        myButtonsArray.add(button20);
        myButtonsArray.add(button21);
        myButtonsArray.add(button22);
        myButtonsArray.add(button23);
        myButtonsArray.add(button24);
        myButtonsArray.add(button25);

        checkGameValidity();
    }

    public void smartFixBoardState(){
        Random random = new Random();
        indicatorBarWrapper.setCurrentColor(myButtonsArray.get(random.nextInt(25)).getCurrentColor());
    }

    public void haltGame(){
        for(ButtonWrapper e: myButtonsArray){
            e.stopTimer();
        }
    }

    /**
     * Checks to ensure that the game is a valid one.
     * For instance, there is a possible color to choose on the board.
     */
    public boolean checkGameValidity(){
        for(ButtonWrapper e: myButtonsArray){
            if(checkButtonColorIndicatorMatch(e.getCurrentColor(),indicatorBarWrapper.getCurrentColor())){
                return true;
            };
        }
        smartFixBoardState();
        return false;
    }

    public boolean checkButtonColorIndicatorMatch(int buttonColor, int indicatorColor){
        boolean matchClicked = false;
        if(buttonColor == indicatorColor){
            matchClicked = true;
        }
        return matchClicked;
    }


    @Override
    public void buttonPressed(ButtonWrapper buttonWrapper) {
        if(checkButtonColorIndicatorMatch(buttonWrapper.getCurrentColor(),indicatorBarWrapper.getCurrentColor())){
            //Toast.makeText(getApplicationContext(),"Good job!",Toast.LENGTH_LONG).show();
            doCorrectMatchWork(buttonWrapper);
        }else{
            doIncorrectMatchWork(buttonWrapper);
        }
    }

    @Override
    public void gameLost(ButtonWrapper lostButton) {
        //Toast.makeText(getApplicationContext(),"You lost the game",Toast.LENGTH_LONG).show();
        indicatorBarWrapper.stopGameTimer();
        //Transfer to new game activity.
        haltGame();
        transferGameState();
    }
    public void transferGameState(){
        Bundle bundle = new Bundle();
        bundle.putInt(global_time_key,indicatorBarWrapper.getGlobalTime());
        bundle.putInt(correct_clicks_key, correctSelections);
        Intent lossScreenTransferIntent = new Intent(getBaseContext(), LossScreen.class);
        lossScreenTransferIntent.putExtras(bundle);
        startActivity(lossScreenTransferIntent);
    }

    public void doCorrectMatchWork(ButtonWrapper correctButtonFound){
        correctSelections++;
        correctButtonFound.randomizeBtnColor();
        correctButtonFound.resetTimer();
        indicatorBarWrapper.determineWeightedPick();
        checkGameValidity();
    }

    public void doIncorrectMatchWork(ButtonWrapper incorrectButtonFound){
        incorrectButtonFound.speedUpTimer();
    }
    @Override
    public void onBackPressed() {
        haltGame();
        super.onBackPressed();
    }

}
