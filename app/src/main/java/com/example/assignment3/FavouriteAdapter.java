package com.example.assignment3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.assignment3.activities.ItemDetailActivity;
import java.util.ArrayList;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder> {

    private ArrayList<Image> favouriteToAdapt = ItemDetailActivity.addToFavourite;

    public void setData(ArrayList<Image> favouriteToAdapt) {
        this.favouriteToAdapt = favouriteToAdapt;
    }

    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite, parent, false);

        FavouriteAdapter.FavouriteViewHolder favouriteViewHolder = new FavouriteAdapter.FavouriteViewHolder(view);
        return favouriteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteViewHolder holder, int position) {
        if(favouriteToAdapt.isEmpty() == true){
            holder.textView.setText("Please add your Cat first!");
        } else{
            holder.textView.setText(favouriteToAdapt.get(position).getItems().get(0).getName());
        }
    }

    @Override
    public int getItemCount() {
        return favouriteToAdapt.size();
    }

    public static class FavouriteViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView textView;

        // This constructor is used in onCreateViewHolder
        public FavouriteViewHolder(View v) {
            super(v);  // runs the constructor for the ViewHolder superclass
            view = v;
            textView = v.findViewById(R.id.textView);

        }

    }

}
