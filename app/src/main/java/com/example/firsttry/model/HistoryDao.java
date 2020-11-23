package com.example.firsttry.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDao {
    @Query("SELECT * FROM history")
    public List<HistoryDB> getAll();

    @Insert()
    public void addHistoryDB(HistoryDB userEntry);

    @Query("DELETE FROM history")
    public void deleteAll();
}
