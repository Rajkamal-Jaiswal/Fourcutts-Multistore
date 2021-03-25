package com.aaratechnologies.fourcutss.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aaratechnologies.fourcutss.CustomListeners.BlogClickListener;
import com.aaratechnologies.fourcutss.R;

public class BlogsAdapter extends RecyclerView.Adapter<BlogsAdapter.offerHolder> {
    Context context;
    BlogClickListener blogClickListener;

    public BlogsAdapter(Context context, BlogClickListener blogClickListener) {
        this.context = context;
        this.blogClickListener = blogClickListener;
    }

    @NonNull
    @Override
    public offerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blogs_layout,parent,false);
        return new offerHolder(view,blogClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull offerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class offerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        BlogClickListener blogClickListener;
        public offerHolder(@NonNull View itemView, BlogClickListener blogClickListener) {
            super(itemView);
            this.blogClickListener = blogClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            blogClickListener.BlogItemClick(getAdapterPosition());
        }
    }
}
