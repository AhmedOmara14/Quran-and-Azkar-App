package com.example.quran.data;

import com.example.quran.pojo.askar_name;
import com.example.quran.pojo.azkar_sabah;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.GET;

public interface askar_interface {
    @GET("list.json")
    Observable<List<askar_name>> getaskar();

    @GET("azkar_sabah.json")
    Observable<azkar_sabah> getazkar_sabah();

    @GET("azkar_massa.json")
    Observable<azkar_sabah> getazkar_mass();

    @GET("PostPrayer_azkar.json")
    Observable<azkar_sabah> getazkar_PostPrayer_azkar();
}
