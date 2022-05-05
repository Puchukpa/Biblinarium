package com.project.biblinarium.mvvm.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.repositories.UserRepository;
import com.project.biblinarium.mvvm.views.ui.pages.books.BooksFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView_navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_books:
                    Log.d("xxx", "Books");
                    return true;
                case R.id.nav_forum:
                    Log.d("xxx", "Forum");
                    return true;
                case R.id.nav_exchange:
                    Log.d("xxx", "Exchange");
                    return true;
                case R.id.nav_reserve:
                    Log.d("xxx", "Reserve");
                    return true;
                case R.id.nav_account:
                    Log.d("xxx", "Account");
                    return true;
            }
            return false;
        });
        getSupportFragmentManager().beginTransaction().add(R.id.layout_mainPanel, new BooksFragment()).commit();
    }
}