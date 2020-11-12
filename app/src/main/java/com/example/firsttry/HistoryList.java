package com.example.firsttry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class HistoryList extends AppCompatActivity {


    HistoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);
        Intent intent = getIntent();
        adapter = new HistoryAdapter();
        if(intent!=null && intent.hasExtra(MainActivity.HISTORY_KEY)) {
            ArrayList<HistoryItem> qs=intent.getParcelableArrayListExtra(MainActivity.HISTORY_KEY);
            adapter.initialize(qs);
        }
            RecyclerView   historyList = findViewById(R.id.rvHistory);
            historyList.setLayoutManager(new LinearLayoutManager(this));
            historyList.setAdapter(adapter);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("back");
        menu.getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent=new Intent(HistoryList.this,MainActivity.class);
                startActivity(intent);
                return false;
            }
        });
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
/*
    @Override


        Intent intent = getIntent();

        adapter = new HistoryListAdapter();
        if(intent!=null && intent.hasExtra(MainActivity.HISTORY_KEY)){
            adapter.initialize(intent.getParcelableArrayListExtra(MainActivity.HISTORY_KEY));
    }

        RecyclerView recyclerView = findViewById(R.id.historyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
 */