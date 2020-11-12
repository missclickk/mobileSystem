package com.example.firsttry;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Locale;

import android.net.Uri;
//TOAST 
public class MainActivity extends AppCompatActivity {
    private Button switchButton;
    public FrameLayout fragmentArea;
    private ArrayList<HistoryItem> history;
    public static final String HISTORY_KEY = "history";


    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        history = new ArrayList<>();
        fragmentArea=findViewById(R.id.test);
        if(fragmentArea!=null)
        setARGBFragment();

    }

    public void Switch(View view) {
        switchButton = findViewById(R.id.Switch);
        if (switchButton.getText().toString() == "SWITCH TO ARGB") {
            setARGBFragment();
            System.out.println("SWITCH TO RGB");
            switchButton.setText("SWITCH TO RGB");
            //3 фрагмента
        } else {
            setRGBFragment();
            System.out.println("SWITCH TO ARGB");
            switchButton.setText("SWITCH TO ARGB");
        }

    }
  private void setARGBFragment(){
      setFragment(ArgbFragment.newInstance());
    }
    private void setRGBFragment(){
        setFragment(RgbFragment.newInstance());
    }
    private void setFragment(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.test,fragment);
        ft.commit();
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(HISTORY_KEY,history);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null && savedInstanceState.containsKey(HISTORY_KEY))
            history = savedInstanceState.getParcelableArrayList(HISTORY_KEY);
    }
    public void addToHistory(HistoryItem newItem){
        history.add(newItem);

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
                intent.putParcelableArrayListExtra(HISTORY_KEY,history);
                startActivity(intent);
                break;
            case R.id.open_backproc_item:
                intent= new Intent(this, BackgroundProcessActivity.class);
                startActivity(intent);
                break;
            case R.id.open_reference:
                Locale current = getResources().getConfiguration().locale;
                String len=current.toString().split("_")[0];
                String link=Link.creteLocalLinkToWikipedia(len);
                intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}