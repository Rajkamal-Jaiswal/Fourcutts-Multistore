package com.aaratechnologies.fourcutss.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aaratechnologies.fourcutss.R;


public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.mHOlder> {
    Context context;

    public FilterAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public mHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_adapter,parent,false);
        return new mHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mHOlder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class mHOlder extends RecyclerView.ViewHolder {
        public mHOlder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
