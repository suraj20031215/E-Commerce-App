package com.example.myapppro.CostumeAdpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapppro.Model_Class.ModelClass;
import com.example.myapppro.R;
import java.lang.CharSequence;
import java.util.ArrayList;

     public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyviewHolder>{

        Context context;
    ArrayList<ModelClass> arrayList7;

    public ItemAdapter(Context context, ArrayList<ModelClass> arrayList7) {
        this.context = context;
        this.arrayList7 = arrayList7;
    }

    @NonNull
    @Override
    public ItemAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.showitem,null,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyviewHolder holder, int position) {
          holder.text.setText(arrayList7.get(position).getName());
          holder.text1.setText(arrayList7.get(position).getDic());
          holder.text2.setText(arrayList7.get(position).getPrice());
          Glide.with(context).load(arrayList7.get(position).getPic()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return arrayList7.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        TextView text,text1,text2;
        ImageView img;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.textView2);
            text1=itemView.findViewById(R.id.textView5);
            text2=itemView.findViewById(R.id.price);
            img=itemView.findViewById(R.id.listimg);
        }
    }
}





