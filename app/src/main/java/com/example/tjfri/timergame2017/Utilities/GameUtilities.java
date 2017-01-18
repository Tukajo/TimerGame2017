package com.example.tjfri.timergame2017.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by TJ Frisch on 1/17/2017.
 */

public class GameUtilities {

    //Private body to prevent instantiation.
    private GameUtilities(){

    }
    public static String formatTime(int time){
        String formattedString = "0:00";
        int minutes=Math.round(time/60);
        int seconds=time%60;
        if(seconds<10){
            formattedString = String.valueOf(minutes)+":0"+String.valueOf(seconds);
        }else{
            formattedString = String.valueOf(minutes)+":"+String.valueOf(seconds);
        }
        return formattedString;
    }

}
