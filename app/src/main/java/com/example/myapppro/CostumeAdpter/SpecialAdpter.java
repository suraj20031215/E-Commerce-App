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

public class SpecialAdpter extends RecyclerView.Adapter<SpecialAdpter.MyviewHolder> {
    private Context context;
    ArrayList<ModelClass> arrayList4;

    public SpecialAdpter(Context context, ArrayList<ModelClass> arrayList4) {
        this.context = context;
        this.arrayList4 = arrayList4;
    }

    @NonNull
    @Override
    public SpecialAdpter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.logoitem,null,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialAdpter.MyviewHolder holder, int position) {

        holder.text.setText(arrayList4.get(position).getName());
        Glide.with(context).load(arrayList4.get(position).getPic()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return arrayList4.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        TextView text;
        ImageView img;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.brandname);
            img=itemView.findViewById(R.id.brandimg);

        }
    }
}
