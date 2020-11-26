package com.example.firsttry.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {HistoryDB.class,ServiceDB.class},version = 3)
public abstract class DatabaseApp extends RoomDatabase {
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "local_data";
    private static DatabaseApp sInstance;
    public static DatabaseApp getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        DatabaseApp.class, DatabaseApp.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries().addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);
                            }
                        }).build();
            }
        }
        return sInstance;
    }

    public abstract HistoryDao historyDao();
    public abstract ServiceDao serviceDao();
}
