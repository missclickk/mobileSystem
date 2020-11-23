package com.example.firsttry.view;
import android.content.Intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firsttry.R;

public class IntentCatcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_catcher);

        TextView textView = findViewById(R.id.shared_link_text);
        Intent intent = getIntent();
        if(intent!=null){
            String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
            textView.setText(sharedText);
        }
    }
}
