package com.example.quran.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class content {
    @SerializedName("zekr")
    @Expose
    private String zekr;

    @SerializedName("bless")
    @Expose
    private String bless;

    public String getZekr() {
        return zekr;
    }

    public void setZekr(String zekr) {
        this.zekr = zekr;
    }

    public String getBless() {
        return bless;
    }

    public void setBless(String bless) {
        this.bless = bless;
    }
}
