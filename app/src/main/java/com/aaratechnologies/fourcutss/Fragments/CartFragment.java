package com.aaratechnologies.fourcutss.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aaratechnologies.fourcutss.Adapters.CartItemsAdapter;
import com.aaratechnologies.fourcutss.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;


public class CartFragment extends Fragment {
    RecyclerView recyclerView;
    //    BottomAppBar continue_btn;
//    Toolbar toolbar_main;
    RelativeLayout text;
    private ShimmerFrameLayout mShimmerViewContainer;
    FrameLayout frameLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);


//        try {
//            bottomNavigationView = Objects.requireNonNull(getActivity()).findViewById(R.id.bottom_navigation);
////        frameLayout = getActivity().findViewById(R.id.container);
//            bottomNavigationView.setSelectedItemId(R.id.cart);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container);
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

        recyclerView = view.findViewById(R.id.recycler_cart);
//        continue_btn = view.findViewById(R.id.continue_btn);
//        toolbar_main = getActivity().findViewById(R.id.toolbar_main);
//        toolbar_main.setTitle("Cart");
//        toolbar_main.setTitleTextColor(Color.WHITE);


//        continue_btn.setOnClickListener( v ->
//                getActivity()
//                        .getSupportFragmentManager()
//                        .beginTransaction()
//                        .addToBackStack("cart")
//                        .replace(R.id.fragment_container,new DeliverySummary())
//                        .commit()
//        );
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CartItemsAdapter(getContext()));
        return view;
    }
}
