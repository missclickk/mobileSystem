package com.example.firsttry.view;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;

import android.net.Uri;

import com.example.firsttry.viewmodel.HistoryFacade;
import com.example.firsttry.viewmodel.ChangeSettings;
import com.example.firsttry.R;
import com.example.firsttry.model.HistoryDB;
import com.example.firsttry.viewmodel.ChangeSettings;
//TOAST
public class MainActivity extends AppCompatActivity {
    private Button switchButton;
    public FrameLayout fragmentArea;
    private ArrayList<HistoryDB> history;
    public static final String HISTORY_KEY = "history";
    private final int RGB_KEY=1;
    private final int ARGB_KEY=2;
    private final int ALL_FRAGMENT_KEY=3;
    private   int fragment_key=1;


    private ConstraintLayout lay;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentArea=findViewById(R.id.fragmentArea);
        if(fragmentArea!=null)
        setARGBFragment();
        findViewById(R.id.Switch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Switch();
            }
        });
        ConstraintLayout lay=findViewById(R.id.lay);
        ChangeSettings.getTextSize(lay,getApplicationContext());
      }


    public void Switch() {

        Button switchButton=findViewById(R.id.Switch);
        switch (fragment_key){
            case(1):
                setARGBFragment();
                switchButton.setText(getResources().getString(R.string.switch_to_rgb));

                break;
            case(2):
                setRGBFragment();
                switchButton.setText(getResources().getString(R.string.switch_to_all));

                break;
            case(3):
                setAllFragment();
                switchButton.setText(getResources().getString(R.string.switch_to_argb));


                break;
        }


    }
    private void setARGBFragment(){
      setFragment(ArgbFragment.newInstance());
        fragment_key=2;
    }
    private void setRGBFragment(){
        setFragment(RgbFragment.newInstance());
        fragment_key=3;
    }
    private void setAllFragment(){
        setFragment(AllFragment.newInstance());
        fragment_key=1;
    }
    private void setFragment(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragmentArea,fragment);
        ft.commit();
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
    public void addToHistory(HistoryDB newItem){
      HistoryFacade.addItem(getBaseContext(),newItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
           getMenuInflater().inflate(R.menu.menu_main, menu);
           return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()){
            case R.id.open_history_item:
                intent = new Intent(this, HistoryList.class);
                intent.putParcelableArrayListExtra(HISTORY_KEY, new ArrayList<>(HistoryFacade.getAllAsList(getBaseContext())));
                startActivity(intent);
                break;
            case R.id.open_backproc_item:
                intent= new Intent(this, ServiceActivity.class);
                startActivity(intent);
                break;
            case R.id.settings:
                intent= new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.open_reference://ПЕРЕДЕЛАТЬ
                String link= ChangeSettings.getLocalLinkToWikipedia(getApplicationContext());
                intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                startActivity(intent);
                break;
            case R.id.open_db_activity:
                intent=new Intent(this, DBactivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected  void onResume(){
        super.onResume();
        ConstraintLayout lay=findViewById(R.id.lay);
        ChangeSettings.getTextSize(lay,getApplicationContext());
    }
}