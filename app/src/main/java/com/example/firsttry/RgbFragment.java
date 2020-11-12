package com.example.firsttry;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class RgbFragment extends Fragment {
    private LinearLayout colorOutput;
    private EditText numR,numG,numB;

    public static RgbFragment newInstance() {
        return new RgbFragment();
    }
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rgb, container, false);
        colorOutput=view.findViewById(R.id.colorOutput);
        numR=view.findViewById(R.id.numR);
        numG=view.findViewById(R.id.numG);
        numB=view.findViewById(R.id.numB);
        view.findViewById(R.id.startRGB).setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                    int R = Integer.parseInt(numR.getText().toString());
                    int G = Integer.parseInt(numG.getText().toString());
                    int B = Integer.parseInt(numB.getText().toString());
                    addHistoryItem(R, G, B);
                   Paint.changeBackGroundColor(colorOutput,R,G,B);
//
                }
            }
        );
        return view;

    }
    private void addHistoryItem(int R,int G,int B){
        //bad style, but will stay till lab7
        String rString = String.format("%1d",R);
        String gString = String.format("%1d",G);
        String bString = String.format("%1d",B);

        MainActivity parent = (MainActivity)getActivity();
        parent.addToHistory(new HistoryItem(rString,gString, bString));
    }
}

