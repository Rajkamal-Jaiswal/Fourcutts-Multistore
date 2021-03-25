package com.aaratechnologies.fourcutss.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.aaratechnologies.fourcutss.Adapters.SearchAdapter;
import com.aaratechnologies.fourcutss.R;
import com.facebook.shimmer.ShimmerFrameLayout;

public class SearchFragment extends Fragment {
    RecyclerView search_recyc;
    Toolbar toolbar_main;
    RelativeLayout toolbar;
    private ShimmerFrameLayout mShimmerViewContainer;
    LinearLayout text;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container);
        toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
        text = view.findViewById(R.id.text);
        text.setVisibility(View.GONE);
        mShimmerViewContainer.setVisibility(View.VISIBLE);
        mShimmerViewContainer.startShimmerAnimation();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // stop animating Shimmer and hide the layout
                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.GONE);
                text.setVisibility(View.VISIBLE);
            }
        }, 1500);
        search_recyc = view.findViewById(R.id.search_recyc);
//        toolbar_main = getActivity().findViewById(R.id.toolbar_main);
//        toolbar_main.setTitle("Search");
//        toolbar_main.setTitleTextColor(Color.WHITE);
        search_recyc.setAdapter(new SearchAdapter(getContext()));
        return view;
    }
}