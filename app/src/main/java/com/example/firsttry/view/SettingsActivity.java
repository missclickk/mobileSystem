package com.example.firsttry.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.firsttry.R;

import org.w3c.dom.NodeList;

public class SettingsActivity extends AppCompatActivity {
    public  static SharedPreferences settings;
    public  static final String APP_PREFERENCE="settings";
    public  static final String APP_PREFERENCE_SIZE="size";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);
        final Spinner spinner=findViewById(R.id.chooseSize);
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.size, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.size);
                settings =getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=settings.edit();
                editor.putString(APP_PREFERENCE_SIZE,choose[selectedItemPosition]);
                editor.apply();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

}