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
import android.widget.Toast;

import com.example.quran.R;
import com.example.quran.pojo.askar_name;
import com.example.quran.pojo.aya;
import com.example.quran.pojo.azkar_sabah;
import com.example.quran.pojo.content;
import com.example.quran.ui.Adapter;
import com.example.quran.ui.Adapter_askar;
import com.example.quran.ui.Adapter_azkar_sabah;
import com.example.quran.ui.postviewmodel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class azkarFragment_save extends Fragment {
    private DatabaseReference reference;
    private FirebaseAuth auth;
    private Adapter_azkar_sabah adapter;
    private RecyclerView recyclerView;
    private postviewmodel postviewmodel;


    View view;
    public azkarFragment_save() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_azkar_save, container, false);
        intialization();
        postviewmodel= ViewModelProviders.of((FragmentActivity) getContext()).get(postviewmodel.class);
        postviewmodel.getitem_sure().observe((LifecycleOwner) getContext(), new Observer<List<content>>() {
            @Override
            public void onChanged(List<content> contents) {
                try {
                    adapter=new Adapter_azkar_sabah(contents,getContext());
                    recyclerView.setAdapter(adapter);
                }
                catch (Exception e){
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }
    public void intialization(){
       recyclerView=view.findViewById(R.id.rec_azkar_save);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
