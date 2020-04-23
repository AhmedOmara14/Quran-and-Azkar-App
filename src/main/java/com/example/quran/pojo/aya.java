package com.example.quran.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class aya {
    @SerializedName("index")
    @Expose
    private String index;

    @SerializedName("text")
    @Expose
    private String text;
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
