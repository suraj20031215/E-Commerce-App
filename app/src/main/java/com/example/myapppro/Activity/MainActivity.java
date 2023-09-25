package com.example.myapppro.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapppro.Fragment.LoginPage;
import com.example.myapppro.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container,new LoginPage()).commit();
    }
}