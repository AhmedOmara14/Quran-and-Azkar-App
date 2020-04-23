package com.example.quran.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quran.R;
import com.example.quran.pojo.aya;
import com.example.quran.pojo.content;

import java.util.ArrayList;
import java.util.List;

public class Adapter_azkar_sabah extends RecyclerView.Adapter<Adapter_azkar_sabah.viewholder>{
    List<content> List=new ArrayList<>();
    Context context;


    public Adapter_azkar_sabah(List<content> List, Context context) {
        this.List= List;
        this.context = context;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.azkar_sab, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.zekr.setText(List.get(position).getZekr());
        holder.blessh.setText(List.get(position).getBless());

    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        TextView blessh,zekr;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            zekr=itemView.findViewById(R.id.text_aekr);
            blessh=itemView.findViewById(R.id.text_blessh);
        }
    }
}
