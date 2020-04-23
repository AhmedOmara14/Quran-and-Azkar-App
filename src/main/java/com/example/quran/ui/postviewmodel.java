package com.example.quran.ui;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quran.data.ayaclient;
import com.example.quran.pojo.app;
import com.example.quran.pojo.askar_name;
import com.example.quran.pojo.aya;
import com.example.quran.pojo.azkar_sabah;
import com.example.quran.pojo.content;
import com.example.quran.pojo.sure;
import com.example.quran.data.ayaclient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class postviewmodel extends ViewModel {
    public MutableLiveData<List<sure>> listMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<List<askar_name>> listMutableLiveData_askar = new MutableLiveData<>();
    public MutableLiveData<List<content>> listMutableLiveData_content = new MutableLiveData<>();
    public MutableLiveData<List<content>> listMutableLiveData_massa = new MutableLiveData<>();
    public MutableLiveData<List<content>> listMutableLiveData_pray = new MutableLiveData<>();
    public MutableLiveData<List<content>> listMutableLiveData_azkar = new MutableLiveData<>();
    public MutableLiveData<List<aya>> listMutableLiveData_aya = new MutableLiveData<>();

    ArrayList<content> contents = new ArrayList<>();
    ArrayList<aya> sures = new ArrayList<>();

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    com.example.quran.data.ayaclient ayaclient;
    private static final String TAG = "postviewmodel";

    public void getsure() {
        Observable<app> appObservable = ayaclient.getInstance().getayas().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<app> appObserver = new Observer<app>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(app app) {
                List<sure> items = app.getQuran().getSures();
                listMutableLiveData.setValue(items);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };
        appObservable.subscribe(appObserver);

        Observable<List<askar_name>> listObservable = ayaclient.getInstance().getaskar().
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Observer<List<askar_name>> listObserver = new Observer<List<askar_name>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<askar_name> askar_names) {
                listMutableLiveData_askar.setValue(askar_names);
                for (int i = 0; i < askar_names.size(); i++) {
                    Log.d(TAG, "onNext: " + askar_names.get(i).getTitle());
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        listObservable.subscribe(listObserver);

        Observable<azkar_sabah> azkar_sabahObservable = ayaclient.getInstance().getazkar_sabah().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<azkar_sabah> azkar_sabahObserver = new Observer<azkar_sabah>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(azkar_sabah azkar_saba) {
                List<content> items = azkar_saba.getContents();
                listMutableLiveData_content.setValue(items);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };
        azkar_sabahObservable.subscribe(azkar_sabahObserver);
        Observable<azkar_sabah> azkar_massObservable = ayaclient.getInstance().getazkar_massa().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<azkar_sabah> azkar_massObserver = new Observer<azkar_sabah>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(azkar_sabah azkar_saba) {
                List<content> items = azkar_saba.getContents();
                listMutableLiveData_massa.setValue(items);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };
        azkar_massObservable.subscribe(azkar_massObserver);
        Observable<azkar_sabah> azkar_prayObservable = ayaclient.getInstance().getafterpray().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<azkar_sabah> azkar_prayObserver = new Observer<azkar_sabah>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(azkar_sabah azkar_saba) {
                List<content> items = azkar_saba.getContents();
                listMutableLiveData_pray.setValue(items);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };
        azkar_prayObservable.subscribe(azkar_prayObserver);
    }

    public MutableLiveData<List<content>> getitem_sure() {
            reference.child("Azkar").child("أذكار الصباح").addValueEventListener(
                    new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {


                        content i = dataSnapshot1.getValue(content.class);
                        contents.add(i);
                        listMutableLiveData_azkar.setValue(contents);

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d(TAG, "onCancelled: " + databaseError.getMessage());
                }
            });


        return listMutableLiveData_azkar;

    }

    public MutableLiveData<List<aya>> getsure_name() {
        reference.child("Quran").child("الفاتحة").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d(TAG, "onDataChange: "+dataSnapshot.getRef().push().getKey()+"");

                listMutableLiveData_aya.setValue(sures);
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                      aya i = dataSnapshot1.getValue(aya.class);
                      sures.add(i);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return listMutableLiveData_aya;
    }

}




