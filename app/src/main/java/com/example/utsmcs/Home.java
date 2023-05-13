package com.example.utsmcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.utsmcs.Fragments.HistoryFragment;
import com.example.utsmcs.Fragments.HomeFragment;
import com.example.utsmcs.Fragments.ScheduleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {

    BottomNavigationView menu;
    HistoryFragment history = new HistoryFragment();
    HomeFragment news = new HomeFragment();
    ScheduleFragment purchases = new ScheduleFragment();
    public static Integer currId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        currId = getIntent().getIntExtra("userId",-1);

        menu = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.containerLayoutHome, news).commit();
        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.history:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerLayoutHome,history).commit();
                        return true;

                    case R.id.news:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerLayoutHome,news).commit();
                        return true;

                    case R.id.purchases:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerLayoutHome,purchases).commit();
                        return true;
                }
                return false;
            }
        });
    }
}