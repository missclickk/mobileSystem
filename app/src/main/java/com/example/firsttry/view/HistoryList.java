package com.example.firsttry.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.firsttry.R;
import com.example.firsttry.model.HistoryDB;
import com.example.firsttry.viewmodel.ChangeSettings;




public class HistoryList extends AppCompatActivity {
    HistoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);


        Intent intent = getIntent();
        adapter = new HistoryAdapter();
        if(intent!=null && intent.hasExtra(MainActivity.HISTORY_KEY)) {
            System.out.println("help me...");
            adapter.initialize(intent.<HistoryDB>getParcelableArrayListExtra(MainActivity.HISTORY_KEY));
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
