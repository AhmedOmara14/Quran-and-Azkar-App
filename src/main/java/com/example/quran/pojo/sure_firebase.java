package com.example.quran.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class sure_firebase {

    private String title;
    @SerializedName("index")
    @Expose
    private String index;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("aya")
    private String aya;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getAya() {
        return aya;
    }

    public void setAya(String aya) {
        this.aya = aya;
    }
}
