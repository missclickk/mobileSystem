package com.example.firsttry.view;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class Paint {


   public static void changeBackGroundColor(View obj, int R, int G, int B){
        obj.setBackground(new ColorDrawable(Color.rgb(R,G,B)));
    }
    public static void changeBackGroundColor(View obj,int A,int R,int G,int B){
        obj.setBackground(new ColorDrawable(Color.argb(A,R,G,B)));
    }
    public static int[] backToBlack(View obj, int R, int G, int B){
       if(R<10)
            R=0;
        if(G<10)
            G=0;
        if(B<10)
            B=0;
        R-=10;
        G-=10;
        B-=10;
       changeBackGroundColor(obj,R,G,B);
       int[] arr={R,G,B};
       return arr;
    };
}
