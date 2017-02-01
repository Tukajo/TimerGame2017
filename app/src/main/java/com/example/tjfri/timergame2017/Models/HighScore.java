package com.example.tjfri.timergame2017.Models;
import org.parceler.Parcel;
@Parcel
public class HighScore {

    public String key;
    public String value;

    public HighScore() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public HighScore(String key, String value) {
        this.key = key;
        this.value = value;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}