package com.example.dabbalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    ArrayList<ExampleItem> exampleList;


    private RecyclerView recyclerView;
    private ExampleAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateFakeData();
        recyclerViewConfig();

        //find buttons
    }

    public void generateFakeData(){
        exampleList = new ArrayList<>();

        exampleList.add(new ExampleItem( "Hitesh Chordiya"));
        exampleList.add(new ExampleItem( "Hitesh Chordiya"));
        exampleList.add(new ExampleItem( "Hitesh Chordiya"));
        exampleList.add(new ExampleItem( "Hitesh Chordiya"));
        exampleList.add(new ExampleItem( "Ghanshyam Patil"));
        exampleList.add(new ExampleItem( "Ghanshyam Patil"));
        exampleList.add(new ExampleItem( "Ghanshyam Patil"));
        exampleList.add(new ExampleItem( "Ghanshyam Patil"));
        exampleList.add(new ExampleItem( "Ghanshyam Patil"));
        exampleList.add(new ExampleItem( "Ghanshyam Patil"));
        exampleList.add(new ExampleItem( "Shriram Rajdeo"));
        exampleList.add(new ExampleItem( "Shriram Rajdeo"));
        exampleList.add(new ExampleItem( "Shriram Rajdeo"));
        exampleList.add(new ExampleItem( "Shriram Rajdeo"));
        exampleList.add(new ExampleItem( "Shriram Rajdeo"));
        exampleList.add(new ExampleItem( "Shriram Rajdeo"));
        exampleList.add(new ExampleItem( "Shriram Rajdeo"));
        exampleList.add(new ExampleItem( "Shriram Rajdeo"));
        exampleList.add(new ExampleItem( "Shriram Rajdeo"));
        exampleList.add(new ExampleItem( "Pranal Kale"));
        exampleList.add(new ExampleItem( "Pranal Kale"));
        exampleList.add(new ExampleItem( "Pranal Kale"));
        exampleList.add(new ExampleItem( "Pranal Kale"));
        exampleList.add(new ExampleItem( "Pranal Kale"));
        exampleList.add(new ExampleItem( "Pranal Kale"));
        exampleList.add(new ExampleItem( "Pranal Kale"));
    }

    public void recyclerViewConfig(){
        //Config  for RV
        recyclerView = findViewById(R.id.recyclerView);
        //Performance
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                  //  Toast.makeText(MainActivity.this,Helper.pos,Toast.LENGTH_LONG);
            Toast.makeText(MainActivity.this,"Position"+(position+1),Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addCard(int position){
        exampleList.add(position, new ExampleItem( "new member added"));
        //adapter.notifyDataSetChanged();
        adapter.notifyItemInserted(position);
    }

    public void deleteCard(int position){
        exampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }


}

