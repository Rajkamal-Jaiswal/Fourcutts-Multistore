package com.aaratechnologies.fourcutss.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.aaratechnologies.fourcutss.R;
import com.facebook.shimmer.ShimmerFrameLayout;


public class UserProfile extends Fragment {

    TextView manage_profile;
    RelativeLayout toolbar;
    ConstraintLayout text;
    private ShimmerFrameLayout mShimmerViewContainer;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container);
        text = view.findViewById(R.id.text);
        toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
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
        manage_profile = view.findViewById(R.id.manage_profile);

//        manage_profile.setOnClickListener( v -> getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("userprofile").replace(R.id.fragment_container,new ManageProfile()).commit());

        return view;
    }
}