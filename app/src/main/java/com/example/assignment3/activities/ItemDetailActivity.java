package com.example.assignment3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.assignment3.Image;
import com.example.assignment3.Item;
import com.example.assignment3.ItemDatabase;
import com.example.assignment3.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemDetailActivity extends AppCompatActivity {


    private TextView name;
    private ImageView imageView;
    private TextView description;
    private TextView weight;
    private TextView temperament;
    private TextView origin;
    private TextView lifeSpan;
    private TextView dogFriendly;
    private TextView strangerFriendly;
    private TextView wikipediaLink;
    private Button favourite;
    public static ArrayList<Image> addToFavourite = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        name = findViewById(R.id.name);
        imageView = findViewById(R.id.imageView);
        description = findViewById(R.id.description);
        weight = findViewById(R.id.weight);
        temperament = findViewById(R.id.temperament);
        origin = findViewById(R.id.origin);
        lifeSpan = findViewById(R.id.lifeSpan);
        dogFriendly = findViewById(R.id.dogFriendly);
        strangerFriendly = findViewById(R.id.strangerFriendly);
        wikipediaLink = findViewById(R.id.wikipediaLink);
        favourite = findViewById(R.id.favourite);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        final Item item = ItemDatabase.getItemById(id);

        name.setText(item.getName());
        description.setText(item.getDescription());
        weight.setText("Weight: Imperial - " + item.getWeight().getImperial() + "Metric - " + item.getWeight().getMetric());
        temperament.setText("Temperament: " + item.getTemperament());
        origin.setText("Origin: " + item.getOrigin());
        lifeSpan.setText("Life Span: " + item.getLifespan());
        dogFriendly.setText("Dog Friendly: " + item.getDogFriendly());
        strangerFriendly.setText("Stranger Friendly: " + item.getStrangerFriendly());
        wikipediaLink.setText("Wikipedia Link: " + item.getWikipediaLink());

        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://api.thecatapi.com/v1/images/search?breed_id=" + id;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //System.out.println(response);
                Gson gson = new Gson();
                Image[] images = gson.fromJson(response, Image[].class);
                final List<Image> imageList = Arrays.asList(images);
                String imageUrl = imageList.get(0).getUrl();
                Glide.with(getApplicationContext()).load(imageUrl).into(imageView);

                favourite.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        favourite.setText("Added to Favourite");
                        addToFavourite.add(imageList.get(0));
                        Intent intent = new Intent();
                        intent.putExtra("name", item.getName());
                        //Context context = v.getContext();
                        //Intent intent = new Intent(context,MainActivity.class);
                        //context.startActivity(intent);
                    }
                });
                requestQueue.stop();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"The request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                errorListener);
        requestQueue.add(stringRequest);

    }
}
