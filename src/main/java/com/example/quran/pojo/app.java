package com.example.quran.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class app {
    @SerializedName("quran")
    @Expose
    quran quran;

    public com.example.quran.pojo.quran getQuran() {
        return quran;
    }

    public void setQuran(com.example.quran.pojo.quran quran) {
        this.quran = quran;
    }
}
