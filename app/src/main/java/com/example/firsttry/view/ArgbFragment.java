package com.example.firsttry.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.firsttry.viewmodel.ChangeSettings;
import com.example.firsttry.R;
import com.example.firsttry.model.HistoryDB;



public class ArgbFragment extends Fragment {
    private LinearLayout colorOutput;
    private Button startButton;
    private EditText numR,numG,numB,numA;
    public static ArgbFragment newInstance() {
        return new ArgbFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_argb, container, false);

        ConstraintLayout lay=view.findViewById(R.id.lay);
        ChangeSettings.getTextSize(lay,view.getContext());

        startButton=view.findViewById(R.id.startArgb);
        numA=view.findViewById(R.id.numAlpha);
        numR=view.findViewById(R.id.numR);
        numG=view.findViewById(R.id.numG);
        numB=view.findViewById(R.id.numB);
        colorOutput=view.findViewById(R.id.colorOutput);
        startButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Integer R = Integer.parseInt(numR.getText().toString());
                        Integer G = Integer.parseInt(numG.getText().toString());
                        Integer B = Integer.parseInt(numB.getText().toString());
                        Integer A = Integer.parseInt(numA.getText().toString());
                        print(A,R,G,B);
                        addHistoryItem(A,R,G,B);
                    }
                }
        );

        return view;
    }
    private void print( int A,int R,int G,int B){
        colorOutput.setBackground(new ColorDrawable(Color.argb(A,R, G, B)));
    }
    private void addHistoryItem(int A,int R,int G,int B){
        //bad style, but will stay till lab7
        String aString=String.format("%1d",A);
        String rString = String.format("%1d",R);
        String gString = String.format("%1d",G);
        String bString = String.format("%1d",B);
        MainActivity parent = (MainActivity)getActivity();
        parent.addToHistory(new HistoryDB(aString,rString,gString, bString));
    }
}
