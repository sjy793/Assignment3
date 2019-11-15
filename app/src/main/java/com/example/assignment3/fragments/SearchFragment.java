package com.example.assignment3.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.assignment3.activities.MainActivity;
import com.example.assignment3.ItemDatabase;
import com.example.assignment3.Item;
import com.example.assignment3.ItemAdapter;
import com.example.assignment3.R;
import com.example.assignment3.activities.MainActivity;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;
    private EditText editQuery;
    public View view;
    private List<Item> item;
    private ItemAdapter adapter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = view.findViewById(R.id.rv_main);
        editQuery = view.findViewById(R.id.editQuery);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        view.findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Search();
            }
        });
        return view;
    }

    public void Search(){

        final ItemAdapter itemAdapter = new ItemAdapter();
        final RequestQueue requestQueue =  Volley.newRequestQueue(getActivity());

        String id = editQuery.getText().toString().trim();
        String url = "https://api.thecatapi.com/v1/breeds/search?q=" + id;

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                Item[] objectArray = gson.fromJson(response, Item[].class);
                List<Item> list = Arrays.asList(objectArray);

                ItemDatabase.saveItemToFakeDatabase(list);
                itemAdapter.setData(list);
                recyclerView.setAdapter(itemAdapter);

                requestQueue.stop();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"The request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity parent = (MainActivity) getActivity();
        parent.showCoolMessage(" You can search Cats now !!! ");
    }

}