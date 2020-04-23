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

import java.util.ArrayList;
import java.util.List;

public class Adapter_ayaes extends RecyclerView.Adapter<Adapter_ayaes.viewholder>{
    List<aya> sureList1=new ArrayList<>();
    Context context;

    public Adapter_ayaes(List<aya> sureList, Context context) {
        this.sureList1 = sureList;
        this.context = context;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout_ayas, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        List<aya> ayaArrayList=new ArrayList<>();
            holder.ayaes.setText(sureList1.get(position).getText()+"("+ sureList1.get(position).getIndex()+")");
    }

    @Override
    public int getItemCount() {
        return sureList1.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        TextView num_aya,ayaes;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            //num_aya=itemView.findViewById(R.id.num_ayas);
            ayaes=itemView.findViewById(R.id.ayaes);
        }
    }
}
