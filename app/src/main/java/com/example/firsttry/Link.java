package com.example.firsttry;

public class Link {
    public static String creteLocalLinkToWikipedia(String len){
        //String link="https://.wikipedia.org/wiki/RGB";
        String buf="https://";
        buf=buf.concat(len);
        buf=buf.concat(".wikipedia.org/wiki/RGB");
        return buf;
    }
}
