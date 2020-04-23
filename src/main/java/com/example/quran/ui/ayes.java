package com.example.quran.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.quran.R;
import com.example.quran.databinding.ActivityAyaesBinding;
import com.example.quran.pojo.aya;
import com.example.quran.pojo.sure;

import java.util.ArrayList;
import java.util.List;

public class ayes extends AppCompatActivity {
    String num_sure, sure;
    Adapter_ayaes adapter;
    Adapter adapter1;
    ArrayList<com.example.quran.pojo.sure> arrayList;
    postviewmodel postviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAyaesBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_ayaes);
        num_sure = getIntent().getExtras().get("num_sure").toString();
       sure = getIntent().getExtras().get("sure").toString();
        binding.nameSure.setText("سورة "+sure);
        binding.Recycler2.setLayoutManager(new LinearLayoutManager(this));
        postviewmodel = ViewModelProviders.of(this).get(postviewmodel.class);
        postviewmodel.getsure();

        postviewmodel.listMutableLiveData.observe(this, new Observer<List<com.example.quran.pojo.sure>>() {
            @Override
            public void onChanged(List<sure> sures) {
                try {
                    ArrayList<aya> list1 = new ArrayList<>();
                    for (int i = 0; i < sures.size(); i++) {
                        if (sures.get(i).getIndex().equals(num_sure)) {
                            for (int f = 0; f < sures.get(i).getAya().size(); f++) {
                                list1.add(sures.get(i).getAya().get(f));
                                adapter = new Adapter_ayaes(list1, ayes.this);
                                adapter1=new Adapter(list1);

                                binding.Recycler2.setAdapter(adapter);
                            }
                        }
                    }
                }
                catch (Exception e){
                    Toast.makeText(ayes.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
