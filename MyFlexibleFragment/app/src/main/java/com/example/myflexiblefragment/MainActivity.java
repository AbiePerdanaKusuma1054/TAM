package com.example.myflexiblefragment;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        HomeFragment mHomeFragment = new HomeFragment();
        mFragmentTransaction.add(R.id.frame_container, mHomeFragment, HomeFragment.class.getSimpleName());
        Log.d("MyFlexibleFragment", "Fragment Name :"+HomeFragment.class.getSimpleName());
        mFragmentTransaction.commit();
    }
}
