package com.example.firsttry.model;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ServiceDao {


        @Query("SELECT * FROM service")
        public List<ServiceDB> getAll();

        @Insert()
        public void addServiceDB(ServiceDB userEntry);

        @Query("DELETE FROM history")
        public void deleteAll();
    }


