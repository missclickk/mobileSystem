package com.example.firsttry;
import android.os.Parcel;
import android.os.Parcelable;



public class HistoryItem implements Parcelable{
    private Boolean ZAEBALO;
    private String A;
    private String R;
    private String G;
    private String B;

    public  HistoryItem(String R,String G,String B){
        this.A="";
        this.R=R;
        this.G=G;
        this.B=B;
    }
    public  HistoryItem(String A,String R,String G,String B){

        this.A=A;
        this.R=R;
        this.G=G;
        this.B=B;
    }
    public static final Creator<HistoryItem> CREATOR = new Creator<HistoryItem>() {
        @Override
        public HistoryItem createFromParcel(Parcel in) {
            return new HistoryItem(in);
        }

        @Override
        public HistoryItem[] newArray(int size) {
            return new HistoryItem[size];
        }
    };

    public String getTextRepresentation(){
        String textRepresentation="something goes wrong!!! ";
        if(A.equals("")) {
            textRepresentation = String.format(" R=%1s, G=%2s, B=%3s",
                    R, G, B);
        }
        else{
            textRepresentation = String.format("A=%1s, R=%2s, G=%3s, B=%4s",
                    A,R, G, B);
        }
        return textRepresentation;
    }
    public String getA(){
        return this.A;
    }
    public String getR(){
        return this.R;
    }
    public String getG(){
        return this.G;
    }
    public String getB(){ return this.B; }
    public Boolean getFlag(){ return this.ZAEBALO; }
    @Override
    public int describeContents() {
        return 0;
    }

    protected HistoryItem(Parcel in) {
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


/*

 */
