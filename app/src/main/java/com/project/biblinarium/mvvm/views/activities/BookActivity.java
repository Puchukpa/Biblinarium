package com.project.biblinarium.mvvm.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.book.BookViewModel;
import com.project.biblinarium.mvvm.views.ui.pages.book.BookTextSettingsFragment;

public class BookActivity extends AppCompatActivity {

    TextView title;
    TextView text;
    TextView pages;
    Button nextPage;
    Button prevPage;
    Button textSettings;

    BookTextSettingsFragment textSettingsFragment;

    public BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);

        bookViewModel.setUp(getIntent());

        title = (TextView) findViewById(R.id.textView_book_title);
        text = (TextView) findViewById(R.id.textView_book_bookPageText);
        pages = (TextView) findViewById(R.id.textView_book_pages);
        nextPage = (Button) findViewById(R.id.button_book_rightArrow);
        prevPage = (Button) findViewById(R.id.button_book_leftArrow);
        textSettings = (Button) findViewById(R.id.button_book_settings);

        textSettingsFragment = new BookTextSettingsFragment();

        title.setText(bookViewModel.getTitle());
        text.setText(bookViewModel.getContent());
        pages.setText("1 / " + bookViewModel.getCurrentBook().getPages());

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.layout_book_textSettings, textSettingsFragment)
                .hide(textSettingsFragment)
                .commit();

        bookViewModel.getFontSize().observe(this, size -> {
            text.setTextSize(size);
        });

        textSettings.setOnClickListener(v -> {
            if (!bookViewModel.isSettingsActivated()) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(textSettingsFragment)
                        .commit();
                bookViewModel.setSettingsActivated(true);
            } else {
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(textSettingsFragment)
                        .commit();
                bookViewModel.setSettingsActivated(false);
            }
        });
    }
}