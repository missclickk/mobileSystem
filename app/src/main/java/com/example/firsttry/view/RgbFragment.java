package com.example.firsttry.view;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.firsttry.viewmodel.ChangeSettings;
import com.example.firsttry.viewmodel.Paint;
import com.example.firsttry.R;
import com.example.firsttry.model.HistoryDB;



public class RgbFragment extends Fragment {
    private LinearLayout colorOutput;
    private EditText numR,numG,numB;

    public static RgbFragment newInstance() {
        return new RgbFragment();
    }
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rgb, container, false);

        ConstraintLayout lay=view.findViewById(R.id.test);
        ChangeSettings.getTextSize(lay,view.getContext());

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

                }
            }
        );
        return view;

    }
    private void addHistoryItem(int R,int G,int B){
        String rString = String.format("%1d",R);
        String gString = String.format("%1d",G);
        String bString = String.format("%1d",B);

        MainActivity parent = (MainActivity)getActivity();
        parent.addToHistory(new HistoryDB("",rString,gString, bString));
    }
}

