package com.example.firsttry.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.firsttry.R;
import com.example.firsttry.view.SettingsActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ChangeSettings {
    public static String getLocalLinkToWikipedia(Context context){
        //String link="https://.wikipedia.org/wiki/RGB";
        Locale current = context.getResources().getConfiguration().locale;
        String len=current.toString().split("_")[0];
        String buf="https://";
        buf=buf.concat(len);
        buf=buf.concat(".wikipedia.org/wiki/RGB");
        return buf;
    }

    public static  void getTextSize(ViewGroup lay,Context context){
        final String APP_PREFERENCE="settings";
        SharedPreferences settings =context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE);
        int size = Integer.parseInt(settings.getString(SettingsActivity.APP_PREFERENCE_SIZE, "15"));
        ChangeSettings.changeTextSize(lay,size);
    }

    public static void changeTextSize(ViewGroup parent,int size) {
            List<TextView> elements=new ArrayList<>();
            elements.addAll(getAllTextElements(parent));
            for(int i=0;i<elements.size();i++)
                elements.get(i).setTextSize(TypedValue.COMPLEX_UNIT_DIP,size);
            //    Typeface type = Typeface.createFromAsset(getAssets())
        //   text.setTypeface(type, Typeface.NORMAL);
        //text= (TextView) child;
        //text.setTextSize(TypedValue.COMPLEX_UNIT_DIP,50);
    }

    private static ArrayList<TextView> getAllTextElements(ViewGroup parent){
        List<TextView> elements=new ArrayList<>();
        for(int i=0;i<parent.getChildCount();i++) {
            Object child=parent.getChildAt(i);
            if(child.getClass().getSuperclass().getSimpleName().equals("ViewGroup"))
            {
                elements.addAll(getAllTextElements((ViewGroup) child));
            }

                   if (child.getClass().getSuperclass().getSuperclass().getSimpleName().equals("TextView")) {

                         elements.add((TextView) child);
                   }


        }
        return (ArrayList<TextView>) elements;
    }
    }