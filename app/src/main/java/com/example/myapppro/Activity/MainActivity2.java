package com.example.myapppro.Activity;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapppro.MainFragment.HomePage;
import com.example.myapppro.MainFragment.MyCart;
import com.example.myapppro.Classes.NetworkChangeReceiver;
import com.example.myapppro.MainFragment.OfferPage;
import com.example.myapppro.MainFragment.ProfilePage;
import com.example.myapppro.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    private BottomNavigationView bottom;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bottom = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().add(R.id.container2,new HomePage()).commit();
        networkChangeReceiver = new NetworkChangeReceiver();

        // Register the NetworkChangeReceiver to listen for connectivity changes
        registerReceiver(networkChangeReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));


//        @Override
//        protected void onDestroy() {
//            super.onDestroy();
//            // Unregister the NetworkChangeReceiver to avoid memory leaks
//            unregisterReceiver(networkChangeReceiver);});


            bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()

            {
                @Override
                public boolean onNavigationItemSelected (@NonNull MenuItem item){
                int itemId = item.getItemId();
                if (itemId == R.id.Profile) {
//         Intent in =new Intent(MainActivity2.this,ProfilePage.class);
//         startActivity(in);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container2, new ProfilePage()).addToBackStack(null).commit();
                    return true;

                } else if (itemId == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container2, new HomePage()).addToBackStack(null).commit();
                    return true;
                } else if (itemId == R.id.wishlist) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container2, new MyCart()).addToBackStack(null).commit();
                    return true;
                } else if (itemId == R.id.cart) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container2, new OfferPage()).addToBackStack(null).commit();
                    return true;
                }

                return false;
            }

            });


//        bottom.setOnNavigationItemSelectedListener(item -> {
//
//            if (item.getItemId() == R.id.Profile) {
//
//                Intent intent = new Intent(getActivity(), ProfilePage.class);
//                startActivity(intent);
//            //  getFragmentManager().beginTransaction().replace(R.id.container2, new ProfilePage()).commit();
//            } else if (item.getItemId() == R.id.brand) {
////                getFragmentManager().beginTransaction().replace(R.id.container2, new OfferPage()).commit();
//            }
////            else {
////
////            }
//
//            return false;
//
//        });



    }


}