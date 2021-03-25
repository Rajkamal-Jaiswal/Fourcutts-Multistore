package com.aaratechnologies.fourcutss.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aaratechnologies.fourcutss.Activities.Product_Description_Activity;
import com.aaratechnologies.fourcutss.Adapters.BlogsAdapter;
import com.aaratechnologies.fourcutss.Adapters.OffersAdapter;
import com.aaratechnologies.fourcutss.Adapters.ShopCategory;
import com.aaratechnologies.fourcutss.Adapters.SliderAdapter;
import com.aaratechnologies.fourcutss.CustomListeners.BlogClickListener;
import com.aaratechnologies.fourcutss.CustomListeners.OffersClickListener;
import com.aaratechnologies.fourcutss.CustomListeners.ShopCategoryOnClick;
import com.aaratechnologies.fourcutss.CustomListeners.categoryOnClick;
import com.aaratechnologies.fourcutss.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.smarteist.autoimageslider.SliderView;


public class HomeFragment extends Fragment implements categoryOnClick, ShopCategoryOnClick, OffersClickListener, BlogClickListener {

    private ShimmerFrameLayout mShimmerViewContainer;
    LinearLayout text;
    RecyclerView shop_cat_recyc, offers_recyc, blog_recyc;
    TextView see_more;
    RelativeLayout toolbar;

    SliderView sliderView;
    int[] img = {R.drawable.eggs, R.drawable.bbq, R.drawable.chicken};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container);
        toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
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


//        recyclerView = view.findViewById(R.id.cat_recycler);
//        recyclerView.setNestedScrollingEnabled(false);
        see_more = view.findViewById(R.id.see_more);
        shop_cat_recyc = view.findViewById(R.id.shop_cat_recyc);
        shop_cat_recyc.setNestedScrollingEnabled(false);
        offers_recyc = view.findViewById(R.id.offers_recyc);
        offers_recyc.setNestedScrollingEnabled(false);
        blog_recyc = view.findViewById(R.id.blog_recyc);
        blog_recyc.setNestedScrollingEnabled(false);
        sliderView = view.findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(img, getContext());
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_RTL);
        sliderView.setAutoCycle(true);
        sliderView.setScrollTimeInSec(3);
        sliderView.startAutoCycle();
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//        recyclerView.setAdapter(new CategoryAdapter(getContext(), this));
        shop_cat_recyc.setLayoutManager(new GridLayoutManager(getContext(), 3));
        shop_cat_recyc.setAdapter(new ShopCategory(getContext(), this));
        offers_recyc.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));
        offers_recyc.setAdapter(new OffersAdapter(getContext(), this));
        blog_recyc.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        blog_recyc.setAdapter(new BlogsAdapter(getContext(), this));
//        see_more.setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OffersSeeMoreFragment()).addToBackStack("HomeFragment").commit());


        return view;
    }

    @Override
    public void categoryItemClick(int item) {
        Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void CategoryOnClick(int cat) {
        Toast.makeText(getContext(), "clicked category", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OffersItemClick(int items) {
        Intent intent1 = new Intent(getContext(), Product_Description_Activity.class);
        getAllowEnterTransitionOverlap();
        startActivity(intent1);
    }

    @Override
    public void BlogItemClick(int blog) {
        Toast.makeText(getContext(), "clicked Blog Item", Toast.LENGTH_SHORT).show();
//        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductDetailFragment()).addToBackStack("ProductDetailFragment").commit();
    }

}