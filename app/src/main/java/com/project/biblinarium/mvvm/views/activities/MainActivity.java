package com.project.biblinarium.mvvm.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.repositories.UserRepository;
import com.project.biblinarium.mvvm.views.ui.pages.account.AccountFragment;
import com.project.biblinarium.mvvm.views.ui.pages.books.BooksFragment;
import com.project.biblinarium.mvvm.views.ui.pages.exchange.ExchangeFragment;
import com.project.biblinarium.mvvm.views.ui.pages.forum.ForumFragment;
import com.project.biblinarium.mvvm.views.ui.pages.reserve.ReserveFragment;

public class MainActivity extends AppCompatActivity {

    BooksFragment booksFragment = new BooksFragment();
    ForumFragment forumFragment = new ForumFragment();
    ExchangeFragment exchangeFragment = new ExchangeFragment();
    ReserveFragment reserveFragment = new ReserveFragment();
    AccountFragment accountFragment = new AccountFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.layout_mainPanel, booksFragment).commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView_navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_books:
                    getSupportFragmentManager().beginTransaction().replace(R.id.layout_mainPanel, booksFragment).commit();
                    return true;
                case R.id.nav_forum:
                    getSupportFragmentManager().beginTransaction().replace(R.id.layout_mainPanel, forumFragment).commit();
                    return true;
                case R.id.nav_exchange:
                    getSupportFragmentManager().beginTransaction().replace(R.id.layout_mainPanel, exchangeFragment).commit();
                    return true;
                case R.id.nav_reserve:
                    getSupportFragmentManager().beginTransaction().replace(R.id.layout_mainPanel, reserveFragment).commit();
                    return true;
                case R.id.nav_account:
                    getSupportFragmentManager().beginTransaction().replace(R.id.layout_mainPanel, accountFragment).commit();
                    return true;
            }
            return false;
        });
    }
}