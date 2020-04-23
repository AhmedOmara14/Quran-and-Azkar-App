package com.example.quran.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class askar_name {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("filename")
    @Expose
    private String filename;


    public String getTitle() {
        return title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
