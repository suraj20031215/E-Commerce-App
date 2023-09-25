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

public class BannerAdpter extends RecyclerView.Adapter<BannerAdpter.MyviewHolder> {
    Context context;
  ArrayList<ModelClass> arrayList;

    public BannerAdpter(Context context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.offer,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

      Glide.with(context).load(arrayList.get(position).getPic()).into(holder.img6);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{

        ImageView img6;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            img6=itemView.findViewById(R.id.bannerimg);

        }
    }
}
