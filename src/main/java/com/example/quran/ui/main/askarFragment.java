package com.example.quran.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.quran.R;
import com.example.quran.pojo.askar_name;
import com.example.quran.pojo.sure;
import com.example.quran.ui.Adapter;
import com.example.quran.ui.Adapter_askar;
import com.example.quran.ui.postviewmodel;

import java.util.List;


public class askarFragment extends Fragment {
    private RecyclerView recyclerView;
    private Button btn;
    private EditText searchView;
    private View view;
    private Adapter_askar adapter;
    private com.example.quran.ui.postviewmodel postviewmodel;
    public askarFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_askar, container, false);
        intialization();
        postviewmodel.listMutableLiveData_askar.observe(getViewLifecycleOwner(), new Observer<List<askar_name>>() {
            @Override
            public void onChanged(List<askar_name> askar_names) {
                adapter=new Adapter_askar(askar_names, getContext());
                recyclerView.setAdapter(adapter);
            }
        });
        return view;
    }

    private void intialization() {
        recyclerView=view.findViewById(R.id.Recycler_askar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        postviewmodel = ViewModelProviders.of(this).get(com.example.quran.ui.postviewmodel.class);
        postviewmodel.getsure();

    }
}
