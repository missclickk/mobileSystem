package com.example.firsttry.model;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public  class HistoryDB implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public long id;
    private String A;
    private String R;
    private String G;
    private String B;

    public String getA() {
        return A;
    }

    public String getR() {
        return R;
    }

    public String getB() {
        return B;
    }

    public String getG() {
        return G;
    }

    public HistoryDB(String A, String R, String G, String B) {
        this.A = A;
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public static final Parcelable.Creator<HistoryDB> CREATOR = new Parcelable.Creator<HistoryDB>() {
        @Override
        public HistoryDB createFromParcel(Parcel in) {
            return new HistoryDB(in);
        }

        @Override
        public HistoryDB[] newArray(int size) {
            return new HistoryDB[size];
        }
    };

    public String getTextRepresentation() {
        String textRepresentation = "something goes wrong!!! ";
        if (A.equals("")) {
            textRepresentation = String.format(" R=%1s, G=%2s, B=%3s",
                    R, G, B);
        } else {
            textRepresentation = String.format("A=%1s, R=%2s, G=%3s, B=%4s",
                    A, R, G, B);
        }
        return textRepresentation;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    protected HistoryDB(Parcel in) {
        A = in.readString();
        R = in.readString();
        G = in.readString();
        B = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(A);
        dest.writeString(R);
        dest.writeString(G);
        dest.writeString(B);
    }
}


