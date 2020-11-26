package com.example.firsttry.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.firsttry.viewmodel.HistoryFacade;
import com.example.firsttry.R;
import com.example.firsttry.viewmodel.ServiceFacade;

public class DBactivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_bactivity);
        Button getButton=findViewById(R.id.get_db_data_button);
        Button delButton=findViewById(R.id.delete_db_data_button);
        Button cleanButton=findViewById(R.id.clean_text_button);
        Button getServiceButton=findViewById(R.id.get_db_service_data);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text=findViewById(R.id.text_area);
                text.setText(HistoryFacade.getAll(getBaseContext()));
            }
        });

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HistoryFacade.deleteAll(getBaseContext());
            }
        });
        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanText();
            }
        });
        getServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text=findViewById(R.id.text_area);
                text.setText(ServiceFacade.getAll(getBaseContext()));
            }
        });
    }


    private  void cleanText(){
        text=findViewById(R.id.text_area);
        text.setText("");
    }
}