package com.aaratechnologies.fourcutss.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aaratechnologies.fourcutss.CustomListeners.OffersClickListener;
import com.aaratechnologies.fourcutss.R;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.offerHolder> {
    Context context;
    OffersClickListener offersClickListener;

    public OffersAdapter(Context context, OffersClickListener offersClickListener) {
        this.context = context;
        this.offersClickListener = offersClickListener;
    }

    @NonNull
    @Override
    public offerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_products_layout,parent,false);
        return new offerHolder(view,offersClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull offerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class offerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        OffersClickListener offersClickListener;
        public offerHolder(@NonNull View itemView, OffersClickListener offersClickListener) {
            super(itemView);
            this.offersClickListener = offersClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            offersClickListener.OffersItemClick(getAdapterPosition());
        }
    }
}

