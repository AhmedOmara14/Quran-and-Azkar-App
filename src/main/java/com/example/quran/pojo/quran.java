package com.example.quran.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class quran {
    @SerializedName("sura")
    @Expose
    private ArrayList<sure> sures;

    public ArrayList<sure> getSures() {
        return sures;
    }

    public void setSures(ArrayList<sure> sures) {
        this.sures = sures;
    }

}
