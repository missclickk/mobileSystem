package com.example.firsttry.viewmodel;

import android.content.Context;

import com.example.firsttry.model.DatabaseApp;
import com.example.firsttry.model.HistoryDB;

import java.util.List;

public class HistoryFacade {
    public static void addItem(Context context, HistoryDB newItem){
        DatabaseApp.getInstance(context).historyDao().addHistoryDB(newItem);
    }
    public static String getAll(Context context){
       List<HistoryDB> items= DatabaseApp.getInstance(context).historyDao().getAll();
       for(int i=0;i<items.size();i++)
           System.out.println(items.get(i).getR());

       StringBuilder sb=new StringBuilder();
       for(HistoryDB historyDB:items)
           sb.append(historyDB.getTextRepresentation()).append("\n");
       return sb.toString();
    }
    public static void deleteAll(Context context){
        DatabaseApp.getInstance(context).historyDao().deleteAll();
    }

    public static List<HistoryDB> getAllAsList(Context context) {
        return DatabaseApp.getInstance(context).historyDao().getAll();
    }
}
