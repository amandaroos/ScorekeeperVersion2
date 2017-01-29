package com.example.amanda.scorekeeper2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Amanda on 11/10/2016.
 */

public class PlayerAdapter extends ArrayAdapter<Player> {

    /**
     * This is a custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param players        A List of Player objects to display in a list
     */
    public PlayerAdapter(Activity context, ArrayList<Player> players) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, players);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Player} object located at this position in the list
        final Player currentPlayer = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.player_name);
        // Get the Miwok translation for the current Word object and
        // set this text on the Miwok TextView
        nameTextView.setText(currentPlayer.getName());

        //Find the ImageButton in the list_item.xml with the ID add
        ImageButton addButton = (ImageButton) listItemView.findViewById(R.id.add);
        //Set the image resource for this ImageButton
        addButton.setImageResource(R.drawable.ic_add);


        final TextView scoreTextView = (TextView) listItemView.findViewById(R.id.player_score);
        scoreTextView.setText(String.valueOf(currentPlayer.getScore()));

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                currentPlayer.addScore(1);
                scoreTextView.setText(String.valueOf(currentPlayer.getScore()));
            }
        });

        ImageButton subtractButton = (ImageButton) listItemView.findViewById(R.id.subtract);
        //Set the image resource for this ImageButton
        subtractButton.setImageResource(R.drawable.subtract);

        subtractButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                currentPlayer.addScore(-1);
                scoreTextView.setText(String.valueOf(currentPlayer.getScore()));
            }
        });

        return listItemView;
    }


}
