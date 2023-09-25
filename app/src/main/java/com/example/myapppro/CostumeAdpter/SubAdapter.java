package com.example.myapppro.CostumeAdpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.myapppro.Model_Class.ModelClass;
import com.example.myapppro.R;
import java.util.ArrayList;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.MyviewHolder> {

    private Context context;
    private ArrayList<ModelClass> arrayList10;

    public SubAdapter(Context context, ArrayList<ModelClass> arrayList10) {
        this.context = context;
        this.arrayList10 = arrayList10;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.cat_item,null,false);

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.subtxt.setText(arrayList10.get(position).getName());
        Glide.with(context).load(arrayList10.get(position).getPic()).into(holder.subimg);
    }

    @Override
    public int getItemCount() {
        return arrayList10.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        TextView subtxt;

        ImageView subimg;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            subimg=itemView.findViewById(R.id.listimg);
            subtxt=itemView.findViewById(R.id.listtxt);

        }
    }
}
