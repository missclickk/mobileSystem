package com.example.firsttry;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Paint {


   public static void changeBackGroundColor(View obj, int R, int G, int B){
        obj.setBackground(new ColorDrawable(Color.rgb(R,G,B)));
    }
    public static void changeBackGroundColor(View obj,int A,int R,int G,int B){
        obj.setBackground(new ColorDrawable(Color.argb(A,R,G,B)));
    }
}
