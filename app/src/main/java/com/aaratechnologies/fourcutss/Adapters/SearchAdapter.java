package com.aaratechnologies.fourcutss.Adapters;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aaratechnologies.fourcutss.R;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.mHolder> {
    Context context;

    public SearchAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public mHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.search_adapter,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull mHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class mHolder extends RecyclerView.ViewHolder {
        public mHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
