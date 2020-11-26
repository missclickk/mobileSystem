package com.example.firsttry.view;

import android.app.PendingIntent;
import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firsttry.model.ServiceDB;
import com.example.firsttry.viewmodel.CounterService;
import com.example.firsttry.viewmodel.Files;
import com.example.firsttry.R;
import com.example.firsttry.viewmodel.ServiceFacade;

public class ServiceActivity extends AppCompatActivity {


    public static final String PENDING_INTENT_KEY = "pending_intent";
    public static final String RAND_MAX = "randMax";
    public static final String COUNTER_ANSWER_KEY = "pending_intent";

    private static final int COUNTER_SERVICE = 1;

    public static final int COUNTER_START = 1;
    public static final int COUNTER_ANSWER = 2;
    public static final int COUNTER_FINISH = 3;
    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Button start = findViewById(R.id.start_service_button);
        Button stop = findViewById(R.id.stop_service_button);
        Button last=findViewById(R.id.last);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService();
            }
        });
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Files files=new Files(getApplicationContext());
                TextView text=findViewById(R.id.randNumberInput);
                text.setText(files.readFile());
            }
        });
    }

    public void startService(){
        PendingIntent pendingIntent = createPendingResult(COUNTER_SERVICE, new Intent(), 0);
        Intent intent = new Intent(this, CounterService.class);
        intent.putExtra(PENDING_INTENT_KEY, pendingIntent);
        startService(intent);
    }

    public void stopService(){
        Intent intent = new Intent(this, CounterService.class);
        stopService(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == COUNTER_SERVICE) {
            switch (resultCode) {
                case COUNTER_START:
                    Toast.makeText(this, getResources().getString(R.string.process_start), Toast.LENGTH_SHORT).show();
                    break;
                case COUNTER_ANSWER:
                    int[] responseArray = data.getIntArrayExtra(COUNTER_ANSWER_KEY);
                    Toast.makeText(this, getResources().getString(R.string.rand_number, responseArray[1],responseArray[0]), Toast.LENGTH_SHORT).show();
                    Files files=new Files(getApplicationContext());
                    files.writeFile(responseArray[0]);
                    ServiceFacade.addItem(getApplicationContext(),new ServiceDB(responseArray[0]));
                    break;
                case COUNTER_FINISH:
                    Toast.makeText(this, getResources().getString(R.string.process_stop), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
