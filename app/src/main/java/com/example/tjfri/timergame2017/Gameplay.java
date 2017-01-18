package com.example.tjfri.timergame2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import com.example.tjfri.timergame2017.Models.ButtonWrapper;
import java.util.ArrayList;

public class Gameplay extends AppCompatActivity{
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25;
    private ButtonWrapper button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,button20,button21,button22,button23,button24,button25;

    private int timeInMs = 30000, tickInterval = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

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

        //Construct wrappers
        button1 = new ButtonWrapper(getApplicationContext(),btn1,timeInMs,tickInterval);
        button2 = new ButtonWrapper(getApplicationContext(),btn2,timeInMs,tickInterval);
        button3 = new ButtonWrapper(getApplicationContext(),btn3,timeInMs,tickInterval);
        button4 = new ButtonWrapper(getApplicationContext(),btn4,timeInMs,tickInterval);
        button5 = new ButtonWrapper(getApplicationContext(),btn5,timeInMs,tickInterval);
        button6 = new ButtonWrapper(getApplicationContext(),btn6,timeInMs,tickInterval);
        button7 = new ButtonWrapper(getApplicationContext(),btn7,timeInMs,tickInterval);
        button8 = new ButtonWrapper(getApplicationContext(),btn8,timeInMs,tickInterval);
        button9 = new ButtonWrapper(getApplicationContext(),btn9,timeInMs,tickInterval);
        button10 = new ButtonWrapper(getApplicationContext(),btn10,timeInMs,tickInterval);
        button11 = new ButtonWrapper(getApplicationContext(),btn11,timeInMs,tickInterval);
        button12 = new ButtonWrapper(getApplicationContext(),btn12,timeInMs,tickInterval);
        button13 = new ButtonWrapper(getApplicationContext(),btn13,timeInMs,tickInterval);
        button14 = new ButtonWrapper(getApplicationContext(),btn14,timeInMs,tickInterval);
        button15 = new ButtonWrapper(getApplicationContext(),btn15,timeInMs,tickInterval);
        button16 = new ButtonWrapper(getApplicationContext(),btn16,timeInMs,tickInterval);
        button17 = new ButtonWrapper(getApplicationContext(),btn17,timeInMs,tickInterval);
        button18 = new ButtonWrapper(getApplicationContext(),btn18,timeInMs,tickInterval);
        button19 = new ButtonWrapper(getApplicationContext(),btn19,timeInMs,tickInterval);
        button20 = new ButtonWrapper(getApplicationContext(),btn20,timeInMs,tickInterval);
        button21 = new ButtonWrapper(getApplicationContext(),btn21,timeInMs,tickInterval);
        button22 = new ButtonWrapper(getApplicationContext(),btn22,timeInMs,tickInterval);
        button23 = new ButtonWrapper(getApplicationContext(),btn23,timeInMs,tickInterval);
        button24 = new ButtonWrapper(getApplicationContext(),btn24,timeInMs,tickInterval);
        button25 = new ButtonWrapper(getApplicationContext(),btn25,timeInMs,tickInterval);

    }

}
