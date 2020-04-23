package com.example.quran.data;

import com.example.quran.pojo.app;
import com.example.quran.pojo.askar_name;
import com.example.quran.pojo.azkar_sabah;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ayaclient {
    private static final String baseurl="https://raw.githubusercontent.com/syarul/aq_pjk/master/json/";
    private static final String baseurl_askar="https://ahegazy.github.io/muslimKit/json/";

    private apiInterface apiInterface;
    private askar_interface  askarInterface;
    private static ayaclient instance;

    public ayaclient() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiInterface=retrofit.create(apiInterface.class);

        Retrofit retrofit_askar=new Retrofit.Builder()
                .baseUrl(baseurl_askar)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        askarInterface=retrofit_askar.create(askar_interface.class);


    }

    public static ayaclient getInstance() {
        if (instance==null){
            instance=new ayaclient();
        }
        return instance;
    }

    public Observable<app> getayas(){
        return apiInterface.getapp();
    }
    public Observable<List<askar_name>> getaskar() {
        return askarInterface.getaskar();
    }
     public Observable<azkar_sabah> getazkar_sabah(){
            return askarInterface.getazkar_sabah();
    }
    public Observable<azkar_sabah> getazkar_massa(){
        return askarInterface.getazkar_mass();
    }
    public Observable<azkar_sabah> getafterpray(){
        return askarInterface.getazkar_PostPrayer_azkar();
    }

}
