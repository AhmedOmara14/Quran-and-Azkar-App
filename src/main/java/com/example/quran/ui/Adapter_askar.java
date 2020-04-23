package com.example.quran.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quran.R;
import com.example.quran.pojo.askar_name;
import com.example.quran.pojo.azkar_sabah;
import com.example.quran.pojo.content;
import com.example.quran.pojo.sure;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Adapter_askar extends RecyclerView.Adapter<Adapter_askar.myviewholder> {
    List<askar_name> List=new ArrayList<>();
    Context context;
    DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("ِAzkar");

    public Adapter_askar(List<askar_name> sureList, Context context) {
        this.List = sureList;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.num.setText(position+1+"");
        holder.askar.setText(List.get(position).getTitle());
        final String asakr = List.get(position).getTitle();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(context, showaskar.class);
                intent.putExtra("askar_name", asakr);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView askar, num;
        Button askar_save;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            num = itemView.findViewById(R.id.num);
            askar = itemView.findViewById(R.id.aya);
            askar_save = itemView.findViewById(R.id.btn_save);
        }
    }
}