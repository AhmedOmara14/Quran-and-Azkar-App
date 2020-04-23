package com.example.quran.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class azkar_sabah {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("content")
    @Expose
    private ArrayList<content> contents;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<content> getContents() {
        return contents;
    }

    public void setContents(ArrayList<content> contents) {
        this.contents = contents;
    }
}
