package com.example.quran.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class sure {
    @SerializedName("index")
    @Expose
    private String index;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("aya")
    @Expose
    private ArrayList<aya> aya;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<com.example.quran.pojo.aya> getAya() {
        return aya;
    }

    public void setAya(ArrayList<com.example.quran.pojo.aya> aya) {
        this.aya = aya;
    }
}
