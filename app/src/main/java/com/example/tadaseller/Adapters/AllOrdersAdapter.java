package com.example.tadaseller.Adapters;

import android.content.Context;
import android.view.ContentInfo;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tadaseller.R;

import java.util.zip.Inflater;

public class AllOrdersAdapter extends RecyclerView.Adapter<AllOrdersAdapter.MyViewHolder> {

    String[] name;
    Context context;

    public AllOrdersAdapter(String[] name, Context context) {
        this.name = name;
        this.context = context;
    }

    @NonNull
    @Override
    public AllOrdersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.all_orders_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllOrdersAdapter.MyViewHolder holder, int position) {
        String naam=name[position];
        holder.nameTV.setText(naam);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV=itemView.findViewById(R.id.nameTV);
        }
    }
}
