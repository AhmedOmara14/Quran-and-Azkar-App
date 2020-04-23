package com.example.quran.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quran.R;
import com.example.quran.R;
import com.example.quran.pojo.aya;
import com.example.quran.pojo.sure;
import com.example.quran.ui.Adapter;
import com.example.quran.ui.Adapter_ayaes;
import com.example.quran.ui.postviewmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class quranFragment_save extends Fragment {
    private Adapter_ayaes adapter;
    private RecyclerView recyclerView;
    private View view;
    private postviewmodel postviewmodel;

    public quranFragment_save() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_quran_save, container, false);
        intialization();
        postviewmodel.getsure_name().observe((LifecycleOwner) getContext(), new Observer<List<aya>>() {
            @Override
            public void onChanged(List<aya> sures) {
                adapter=new Adapter_ayaes( sures,getContext());
                recyclerView.setAdapter(adapter);
            }
        });
        return view;
    }
    public void intialization(){
        recyclerView=view.findViewById(R.id.rec_quran_save);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        postviewmodel= ViewModelProviders.of((FragmentActivity) getContext()).get(postviewmodel.class);
    }
}
