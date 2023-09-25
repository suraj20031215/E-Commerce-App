package com.example.myapppro.MainFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapppro.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ProfilePage extends Fragment {

    private BottomNavigationView bottom4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile_page, container, false);
//        bottom4 = view.findViewById(R.id.bottomNavigationView4);
//        bottom4.setOnNavigationItemSelectedListener(item -> {
//
//            if (item.getItemId() == R.id.brand) {
//                getFragmentManager().beginTransaction().replace(R.id.container2, new OfferPage()).addToBackStack(null).commit();
//            }
//            else if (item.getItemId() == R.id.home) {
//                getFragmentManager().beginTransaction().replace(R.id.container2, new HomePage()).addToBackStack(null).commit();
//            }
////            else if {
////
////            }
//
//            return false;
//
//        });



        return view;
    }
}