package com.example.wallspaper.Model;

import com.google.firebase.database.Exclude;

import java.security.Key;

public class DataClass {
    private String imageUrl;
    private String key;

    @Exclude
    public String getKey(){
        return key;
    }

    @Exclude
    public void setKey(String key){
        this.key = key;
    }

    public DataClass(){

    }

    public DataClass(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
