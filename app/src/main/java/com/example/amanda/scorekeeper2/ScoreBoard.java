package com.example.amanda.scorekeeper2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_list);

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Steven"));
        players.add(new Player("Amanda"));
        players.add(new Player("Harry"));
        players.add(new Player("Hermione"));
        players.add(new Player("Frodo"));
        players.add(new Player("Sam"));

        PlayerAdapter itemsAdapter = new PlayerAdapter(this, players);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }

}
