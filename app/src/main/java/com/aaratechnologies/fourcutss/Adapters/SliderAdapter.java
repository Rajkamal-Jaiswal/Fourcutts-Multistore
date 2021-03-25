package com.aaratechnologies.fourcutss.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aaratechnologies.fourcutss.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {
    int[] img;
    Context context;

    public SliderAdapter(int[] img, Context context) {
        this.img = img;
        this.context = context;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_slider,parent,false);
        return new SliderAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, int position) {
        viewHolder.images.setImageResource(img[position]);
    }

    @Override
    public int getCount() {
        return img.length;
    }

    public class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        ImageView images;
        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            images = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
