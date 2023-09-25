package com.example.myapppro.CostumeAdpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapppro.Model_Class.ModelClass;
import com.example.myapppro.R;

import java.util.ArrayList;

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.MyViewHolder> {
    Context context;
    ArrayList<ModelClass> arrayList9;

    public PosterAdapter(Context context, ArrayList<ModelClass> arrayList9) {
        this.context = context;
        this.arrayList9 = arrayList9;
    }

    @NonNull
    @Override
    public PosterAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.poster,parent,false);
        return new PosterAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosterAdapter.MyViewHolder holder, int position) {
        Glide.with(context).load(arrayList9.get(position).getPic()).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return arrayList9.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView poster;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            poster=itemView.findViewById(R.id.posterimg);
        }
    }
}
