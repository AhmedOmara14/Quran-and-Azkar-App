package com.example.quran.data;

import com.example.quran.pojo.app;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface apiInterface {
    @GET("aq.simple.json")
    Observable<app> getapp();
}
