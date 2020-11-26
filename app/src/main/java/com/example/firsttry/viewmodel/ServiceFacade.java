package com.example.firsttry.viewmodel;

import android.content.Context;

import com.example.firsttry.model.DatabaseApp;
import com.example.firsttry.model.ServiceDB;
import com.example.firsttry.model.ServiceDao;

import java.util.List;

public class ServiceFacade {

    public static void addItem(Context context, ServiceDB newItem){
        DatabaseApp.getInstance(context).serviceDao().addServiceDB(newItem);
    }

    public static String getAll(Context context) {
        List<ServiceDB> serviceItems = DatabaseApp.getInstance(context).serviceDao().getAll();
        StringBuilder sb = new StringBuilder();
        for (ServiceDB serviceDB : serviceItems) {
            sb.append(serviceDB.getTextRepresentation()).append("\n");
        }
        return  sb.toString();
    }
}

