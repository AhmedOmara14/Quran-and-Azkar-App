package com.example.quran.ui;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;


import com.example.quran.R;
import com.example.quran.pojo.aya;
import com.example.quran.pojo.sure;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myviewholder> {
    List<sure> sureList = new ArrayList<>();
    Context context;
    postviewmodel postviewmodel;

    private static final String TAG = "Adapter";

    List<aya> ayaList;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Quran");

    FirebaseAuth auth = FirebaseAuth.getInstance();

    public Adapter(List<sure> sureList, Context context) {
        this.sureList = sureList;
        this.context = context;
    }

    public Adapter(List<aya> ayaList) {
        this.ayaList = ayaList;
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.num.setText(sureList.get(position).getIndex());
        holder.sure.setText("سورة " + sureList.get(position).getName());

        final String num_sure = sureList.get(position).getIndex();
        final String sure = sureList.get(position).getName();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(context, ayes.class);
                intent.putExtra("sure", sure);
                intent.putExtra("num_sure", num_sure);
                context.startActivity(intent);


            }
        });
        holder.btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btn_save.setBackgroundResource(R.drawable.ic_bookmark_black_24dp);

                List<aya> ayaList = new ArrayList<>();
                for (int i = 0; i < sureList.get(position).getAya().size(); i++) {
                    ayaList.add(sureList.get(position).getAya().get(i));
                    Log.d(TAG, "onClick: " + ayaList.get(i).getText());

                }
                reference.child(sure).setValue(ayaList).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

    @Override
    public int getItemCount() {
        return sureList.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView sure, num;
        Button btn_save;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            num = itemView.findViewById(R.id.num);
            sure = itemView.findViewById(R.id.aya);
            btn_save = itemView.findViewById(R.id.btn_save);
        }
    }
}