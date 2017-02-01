package com.example.tjfri.timergame2017.Adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tjfri.timergame2017.Models.HighScore;
import com.google.firebase.database.Query;
import java.util.ArrayList;
import java.util.List;

import com.example.tjfri.timergame2017.R;



/**
 * Created by Matteo on 24/08/2015.
 */
public class HighScoreAdapter extends FirebaseRecyclerAdapter<HighScoreAdapter.ViewHolder, HighScore> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewScore;

        public ViewHolder(View view) {
            super(view);
            textViewName = (TextView) view.findViewById(R.id.textview_name);
            textViewScore = (TextView) view.findViewById(R.id.textview_score);
        }
    }

    public HighScoreAdapter(Query query, Class<HighScore> itemClass, @Nullable ArrayList<HighScore> items,
                     @Nullable ArrayList<String> keys) {
        super(query, itemClass, items, keys);
    }

    @Override public HighScoreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.high_score_item, parent, false);

        return new ViewHolder(view);
    }

    @Override public void onBindViewHolder(HighScoreAdapter.ViewHolder holder, int position) {
        HighScore item = getItem(position);
        holder.textViewName.setText(item.getKey());
        holder.textViewScore.setText(item.getValue());
    }

    @Override protected void itemAdded(HighScore item, String key, int position) {
        Log.d("MyAdapter", "Added a new item to the adapter.");
    }

    @Override protected void itemChanged(HighScore oldItem, HighScore newItem, String key, int position) {
        Log.d("MyAdapter", "Changed an item.");
    }

    @Override protected void itemRemoved(HighScore item, String key, int position) {
        Log.d("MyAdapter", "Removed an item from the adapter.");
    }

    @Override protected void itemMoved(HighScore item, String key, int oldPosition, int newPosition) {
        Log.d("MyAdapter", "Moved an item.");
    }
}