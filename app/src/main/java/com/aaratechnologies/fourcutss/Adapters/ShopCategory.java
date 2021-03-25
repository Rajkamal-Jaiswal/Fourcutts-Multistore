package com.aaratechnologies.fourcutss.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aaratechnologies.fourcutss.CustomListeners.ShopCategoryOnClick;
import com.aaratechnologies.fourcutss.R;

public class ShopCategory extends RecyclerView.Adapter<ShopCategory.cat_Holder> {
    Context context;
    ShopCategoryOnClick shopCategoryOnClick;

    public ShopCategory(Context context, ShopCategoryOnClick shopCategoryOnClick) {
        this.context = context;
        this.shopCategoryOnClick = shopCategoryOnClick;
    }

    @NonNull
    @Override
    public cat_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_category,parent,false);
        return new cat_Holder(view,shopCategoryOnClick);
    }

    @Override
    public void onBindViewHolder(@NonNull cat_Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class cat_Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ShopCategoryOnClick shopCategoryOnClick;
        public cat_Holder(@NonNull View itemView, ShopCategoryOnClick shopCategoryOnClick) {
            super(itemView);
            this.shopCategoryOnClick = shopCategoryOnClick;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            shopCategoryOnClick.CategoryOnClick(getAdapterPosition());
        }
    }

}
