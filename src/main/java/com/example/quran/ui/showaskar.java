package com.example.quran.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quran.R;
import com.example.quran.databinding.ActivityShowaskarBinding;
import com.example.quran.pojo.askar_name;
import com.example.quran.pojo.aya;
import com.example.quran.pojo.content;
import com.example.quran.ui.main.Main2Activity;
import com.example.quran.ui.main.askarFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class showaskar extends AppCompatActivity {
    private String askar_name;
    private postviewmodel postviewmodel;
    private ActivityShowaskarBinding binding;
    private Adapter_azkar_sabah adapter;
    private DatabaseReference reference;
    ArrayList<content> contents1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_showaskar);
        askar_name=getIntent().getExtras().get("askar_name").toString();


        intialization();
        if (askar_name.equals("أذكار الصباح")) {
            contents1=new ArrayList<>();
            postviewmodel.listMutableLiveData_content.observe(this, new Observer<List<content>>() {
                @Override
                public void onChanged(List<content> contents) {
                    adapter = new Adapter_azkar_sabah(contents, showaskar.this);
                    binding.RecyclerAzkarSabah.setAdapter(adapter);
                    for (int i=0;i<contents.size();i++){
                        contents1.add(contents.get(i));
                    }
                }
            });
        }
        else   if (askar_name.equals("أذكار المساء")) {
            contents1=new ArrayList<>();
            postviewmodel.listMutableLiveData_massa.observe(this, new Observer<List<content>>() {
                @Override
                public void onChanged(List<content> contents) {
                    adapter = new Adapter_azkar_sabah(contents, showaskar.this);
                    binding.RecyclerAzkarSabah.setAdapter(adapter);
                    for (int i=0;i<contents.size();i++){
                        contents1.add(contents.get(i));
                    }
                }
            });
        }
        else   if (askar_name.equals("أذكار بعد الصلاة")) {
            postviewmodel.listMutableLiveData_pray.observe(this, new Observer<List<content>>() {
                @Override
                public void onChanged(List<content> contents) {
                     contents1=new ArrayList<>();
                    adapter = new Adapter_azkar_sabah(contents, showaskar.this);
                    binding.RecyclerAzkarSabah.setAdapter(adapter);
                    for (int i=0;i<contents.size();i++){
                        contents1.add(contents.get(i));
                    }
                }
            });
        }
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(showaskar.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.child(binding.textView2.getText()+"").setValue(contents1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(showaskar.this, "Ok", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    public void intialization(){
        binding.textView2.setText(askar_name);
        binding.RecyclerAzkarSabah.setLayoutManager(new LinearLayoutManager(this));
        postviewmodel= ViewModelProviders.of(this).get(postviewmodel.class);
        postviewmodel.getsure();
        reference= FirebaseDatabase.getInstance().getReference().child("Azkar");
    }
}
