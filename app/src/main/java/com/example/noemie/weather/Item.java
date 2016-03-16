package com.example.noemie.weather;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class Item extends AppCompatActivity implements ListAdapter.OnClickListener{

    private RecyclerView listRecyclerView;
    private ListAdapter listAdapter;
    private RecyclerView.LayoutManager listLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listRecyclerView = (RecyclerView) findViewById(R.id.list);

        listLayoutManager = new LinearLayoutManager(this);
        listRecyclerView.setLayoutManager(listLayoutManager);

        ArrayList<City> items = new ArrayList<>();
        items.add(new City("Toronto", "Ontario, Canada"));
        items.add(new City("New York", "New York, United States"));
        items.add(new City("Mumbaï", "Maharashtra, India"));
        items.add(new City("London", "England, UK"));

        listAdapter = new ListAdapter(items, this);
        listRecyclerView.setAdapter(listAdapter);
    }

    @Override
    public void onClick(final int position, City city) {


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title
        alertDialogBuilder.setTitle("Your Title");

        // set dialog message
        alertDialogBuilder
                .setMessage("Voulez-vous supprimer cette ville?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        listAdapter.removeAt(position);
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });


        AlertDialog alertDialog = alertDialogBuilder.create();


        alertDialog.show();
    }
}