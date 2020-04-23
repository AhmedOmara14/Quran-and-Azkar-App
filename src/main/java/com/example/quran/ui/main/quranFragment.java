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
import android.widget.SearchView;

import com.example.quran.R;
import com.example.quran.pojo.sure;
import com.example.quran.ui.Adapter;
import com.example.quran.ui.postviewmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class quranFragment extends Fragment {
    private RecyclerView recyclerView;
    private Button btn;
    private EditText searchView;
    private View view;
    private Adapter adapter;
    private com.example.quran.ui.postviewmodel postviewmodel;
    public quranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_quran, container, false);
        intialization();


        postviewmodel.listMutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<sure>>() {
            @Override
            public void onChanged(List<sure> sures) {
                adapter=new Adapter(sures, getContext());
                recyclerView.setAdapter(adapter);

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postviewmodel.listMutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<sure>>() {
                    @Override
                    public void onChanged(List<sure> sures) {
                        adapter=new Adapter(sures, getContext());
                        recyclerView.setAdapter(adapter);
                        ArrayList<sure> list1 = new ArrayList<>();
                        for (int i = 0; i < sures.size(); i++) {

                            if (sures.get(i).getName().contains(searchView.getText().toString().toLowerCase())) {
                                list1.add(sures.get(i));
                                adapter = new Adapter(list1, getContext());
                                recyclerView.setAdapter(adapter);
                            }
                        }
                    }
                });
            }
        });
        return view;
    }

    private void intialization() {
        recyclerView=view.findViewById(R.id.Recycler);
        searchView=view.findViewById(R.id.searchview);
        btn=view.findViewById(R.id.btn);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        postviewmodel = ViewModelProviders.of(this).get(postviewmodel.class);
        postviewmodel.getsure();

    }
}
