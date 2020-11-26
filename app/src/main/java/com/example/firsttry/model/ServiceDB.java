package com.example.firsttry.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "service")
public class ServiceDB  {
    @PrimaryKey(autoGenerate = true)
    public long id;
    private Integer number;


    public Integer getNumber() {
        return number;
    }

    public  ServiceDB(Integer number) {
            this.number = number;
    }

    public String getTextRepresentation() {
        String textRepresentation = "something goes wrong!!! ";
            textRepresentation = String.format(" Number:%1s",
                    number);
        return textRepresentation;
    }


}
