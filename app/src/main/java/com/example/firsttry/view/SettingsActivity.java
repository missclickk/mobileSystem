package com.example.firsttry.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.firsttry.R;
import com.example.firsttry.viewmodel.ChangeSettings;

import org.w3c.dom.NodeList;

public class SettingsActivity extends AppCompatActivity {
    public static SharedPreferences settings;
    public static final String APP_PREFERENCE = "settings";
    public static final String APP_PREFERENCE_SIZE = "size";
    public static final String APP_PREFERENCE_MENU_ELEMENTS = "menuElements";
    CheckBox history ;
    CheckBox service ;
    CheckBox reference ;
    CheckBox database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        history = findViewById(R.id.historyBox);
      service = findViewById(R.id.backProcBox);
       reference = findViewById(R.id.referenceBox);
    database = findViewById(R.id.databaseBox);
       int []menuHideElements= ChangeSettings.getMenuElements(getApplicationContext());
        LinearLayout menu=findViewById(R.id.menuList);
       for(int i=0;i<menu.getChildCount();i++)
           if(menuHideElements[i]==1)
           {
               CheckBox buf= (CheckBox) menu.getChildAt(i);
               buf.setChecked(true);
           }


        final Spinner spinner = findViewById(R.id.chooseSize);
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.size, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.size);
                settings = getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString(APP_PREFERENCE_SIZE, choose[selectedItemPosition]);
                editor.apply();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        int count=0;
      history = findViewById(R.id.historyBox);
        service = findViewById(R.id.backProcBox);
        reference = findViewById(R.id.referenceBox);
       database = findViewById(R.id.databaseBox);
        if (history.isChecked())
            count+=1;
        if (service.isChecked())
            count+=2;
        if (reference.isChecked())
            count+= 4;
        if (database.isChecked())
            count+=8;

        settings = getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(APP_PREFERENCE_MENU_ELEMENTS, count);
        editor.apply();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        int count=0;
        CheckBox history = findViewById(R.id.historyBox);
        CheckBox service = findViewById(R.id.backProcBox);
        CheckBox reference = findViewById(R.id.referenceBox);
        CheckBox database = findViewById(R.id.databaseBox);
        if (history.isChecked())
            count+=1;
        if (service.isChecked())
            count+=2;
        if (reference.isChecked())
            count+= 4;
        if (database.isChecked())
            count+=8;

            settings = getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt(APP_PREFERENCE_MENU_ELEMENTS, count);
            editor.apply();

    }
}