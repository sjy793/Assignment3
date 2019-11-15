package com.example.assignment3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assignment3.activities.ItemDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    private List<Item> itemsToAdapt;

    public void setData(List<Item> itemsToAdapt) {
        this.itemsToAdapt = itemsToAdapt;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search, parent, false);

        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Item itemAtPosition = itemsToAdapt.get(position);
        holder.bind(itemAtPosition);
    }

    @Override
    public int getItemCount() {
        return itemsToAdapt.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView textView;

        // This constructor is used in onCreateViewHolder
        public ItemViewHolder(View v) {
            super(v);  // runs the constructor for the ViewHolder superclass
            view = v;
            textView = v.findViewById(R.id.textView);

        }

        public void bind(final Item item) {
            textView.setText(item.getName());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();

                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra("id", item.getId());
                    //intent.putExtra("name", item.getName());
                    context.startActivity(intent);
                }
            });

            //String imageUrl = book.getBookImage();
            //Glide.with(view.getContext()).load(imageUrl).into(coverImageView);
        }
    }

}
