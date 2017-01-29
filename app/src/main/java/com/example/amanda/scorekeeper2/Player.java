package com.example.amanda.scorekeeper2;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Amanda on 11/10/2016.
 */

public class Player {

    String mName;
    int mScore = 0;

    public Player(String name){
        mName = name;
    }

    public String getName() {return mName;}

    public int getScore() {return mScore;}

    public void addScore(int value) {
        mScore = mScore + value;
    }

}
