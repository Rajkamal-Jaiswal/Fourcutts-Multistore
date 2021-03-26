package com.aaratechnologies.fourcutss.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.aaratechnologies.fourcutss.Fragments.CartFragment;
import com.aaratechnologies.fourcutss.Fragments.HomeFragment;
import com.aaratechnologies.fourcutss.Fragments.SearchFragment;
import com.aaratechnologies.fourcutss.Fragments.UserProfile;
import com.aaratechnologies.fourcutss.R;
import com.aaratechnologies.fourcutss.Utils.SharedPreferenceUser;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    ImageView menu_Icon;
    DrawerLayout drawer;

    FrameLayout frameLayout;
    ImageView cart;
    RelativeLayout toolbar;
    BottomNavigationView bottomNavigationView;
    RelativeLayout logOut_Section;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_Icon = findViewById(R.id.menu_ic);
        logOut_Section = findViewById(R.id.logOut_Section);
        drawer = findViewById(R.id.drawer);

        cart = findViewById(R.id.cart);
//        FirstTimeAddFragment(new HomeFragment());

        //Bottom Nav
        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        frameLayout = findViewById(R.id.container);
        bottomNavigationView.setSelectedItemId(R.id.home);
        FirstTimeAddFragment(new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        Fragment fragment;
                        switch (item.getItemId()) {

                            case R.id.home:
//                                bottomNavigationView.setSelectedItemId(R.id.dash);
                                ReplaceFragment(new HomeFragment());
                                return true;
//                            case R.id.cart:
////                                bottomNavigationView.setSelectedItemId(R.id.wishlist);
//                                ReplaceFragment(new CartFragment());
//                                return true;
                            case R.id.search:
//
//                                bottomNavigationView.setSelectedItemId(R.id.categories);
                                ReplaceFragment(new SearchFragment());
                                return true;
                            case R.id.category:
//
//                                bottomNavigationView.setSelectedItemId(R.id.myaccount);
//                                ReplaceFragment(new FilterCategory());
                                startActivity(new Intent(getApplicationContext(), CategoriesListActivity.class));
                                return true;
                            case R.id.settings:
                                ReplaceFragment(new UserProfile());
                                return true;

                        }

                        return false;
                    }
                });
        menu_Icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else drawer.openDrawer(GravityCompat.START);
            }
        });


        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent1=new Intent(getApplicationContext(),CartActivity.class);
               startActivity(intent1);
//                ReplaceFragment(new CartFragment());
            }
        });

        logOut_Section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferenceUser.getInstance(getApplicationContext()).logout();
                Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }


    private void ReplaceFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.setCustomAnimations(R.anim.enetr_from_right, R.anim.exit_to_right, R.anim.enter_from_left, R.anim.exit_to_left);
//            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    private void FirstTimeAddFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enetr_from_right, R.anim.exit_to_right, R.anim.enter_from_left, R.anim.exit_to_left);
        fragmentTransaction.add(R.id.container, fragment);
//        fragmentTransaction.addToBackStack(backStateName);
        fragmentTransaction.commit();
    }



    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please press BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 1500);
    }
}