package com.aaratechnologies.fourcutss.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.aaratechnologies.fourcutss.Adapters.CartItemsAdapter;
import com.aaratechnologies.fourcutss.R;
import com.facebook.shimmer.ShimmerFrameLayout;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //    BottomAppBar continue_btn;
//    Toolbar toolbar_main;
    RelativeLayout text;
    private ShimmerFrameLayout mShimmerViewContainer;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar();
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        text = findViewById(R.id.text);
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

        recyclerView = findViewById(R.id.recycler_cart);
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
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CartItemsAdapter(getApplicationContext()));
      
    }
    private void Toolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.black_arrow_back_ios_24);
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        toolbar.setTitle("");
        toolbar.setBackgroundColor(getResources().getColor(R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}