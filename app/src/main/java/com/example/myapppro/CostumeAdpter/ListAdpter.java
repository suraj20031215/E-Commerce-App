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
import com.example.myapppro.Interface.Click;
import com.example.myapppro.Model_Class.ModelClass;
import com.example.myapppro.R;

import java.util.ArrayList;

public class ListAdpter extends RecyclerView.Adapter<ListAdpter.MyviewHolder> {
    Context context;
    ArrayList<ModelClass> arrayList1;

    Click click;



    public ListAdpter(Context context, ArrayList<ModelClass> arrayList1) {
        this.context = context;
        this.arrayList1 = arrayList1;

    }



    @NonNull
    @Override
    public ListAdpter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cat_item,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdpter.MyviewHolder holder, int position) {
        holder.txt.setText(arrayList1.get(position).getName());
        Glide.with(context).load(arrayList1.get(position).getPic()).into(holder.imgview);
        holder.imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.GetPos(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView imgview;
        TextView txt;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.listimg);
            txt = itemView.findViewById(R.id.listtxt);
        }


        }
    public void setOn(Click click){
        this.click=click;
    }
    }


