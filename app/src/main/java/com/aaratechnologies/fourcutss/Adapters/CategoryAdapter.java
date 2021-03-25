package com.aaratechnologies.fourcutss.Adapters;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aaratechnologies.fourcutss.CustomListeners.categoryOnClick;
import com.aaratechnologies.fourcutss.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.myHolder> {
    Context context;
    categoryOnClick cat_click;
    //    int[] cat_img;
//    String[] cat_names;
    int index;
    boolean status = false;


    public CategoryAdapter(Context context, categoryOnClick cat_click) {
        this.context = context;
        this.cat_click = cat_click;
//        this.cat_img = cat_img;
//        this.cat_names = cat_names;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_category,parent,false);
        return new myHolder(view,cat_click);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        if(index == position)
        {
            if (status) {
//                holder.cat_img.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                holder.card.setCardBackgroundColor(Color.parseColor("#0C9552"));
                status = true;
            }
        }else {
//            holder.cat_img.setImageTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
            holder.card.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
            status = true;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class myHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        categoryOnClick cat_click;
        CardView card;
        //       TextView textView;
        ImageView cat_img;


        public myHolder(@NonNull View itemView, categoryOnClick categoryOnClick) {
            super(itemView);
            this.cat_click = categoryOnClick;

            card = itemView.findViewById(R.id.cardview);
//            textView = itemView.findViewById(R.id.cat_text);
            cat_img = itemView.findViewById(R.id.cat_img);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            cat_click.categoryItemClick(getAdapterPosition());
            index = getAdapterPosition();
            notifyDataSetChanged();
        }
    }

}
