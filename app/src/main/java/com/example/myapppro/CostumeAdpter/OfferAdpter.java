package com.example.myapppro.CostumeAdpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapppro.Model_Class.ModelClass;
import com.example.myapppro.R;

import java.util.ArrayList;

public class OfferAdpter extends RecyclerView.Adapter<OfferAdpter.MyviewHolder> {
    private Context context;
    ArrayList<ModelClass> arrayList2;

    public OfferAdpter(Context context, ArrayList<ModelClass> arrayList2) {
        this.context = context;
        this.arrayList2 = arrayList2;
    }


    @NonNull
    @Override
    public OfferAdpter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,null,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdpter.MyviewHolder holder, int position) {
//      holder.text.setText(arrayList2.get(position).getName1());
//        Glide.with(context).load(arrayList2.get(position).getImg1()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return arrayList2.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        TextView text;
        ImageView img;

         public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.textView3);
            img=itemView.findViewById(R.id.offerimg);

        }
    }
}
