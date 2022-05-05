package com.project.biblinarium.mvvm.viewModels;

import android.content.Intent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Book;
import com.project.biblinarium.mvvm.repositories.BooksRepository;

public class BookViewModel extends ViewModel {

    private Book currentBook;
    private String title;
    private String content;
    private BooksRepository booksRepository;
    private boolean settingsActivated;

    private MutableLiveData<Integer> fontSize = new MutableLiveData<>(18);

    public void setUp(Intent intent) {
        String title = intent.getStringExtra(Intent.EXTRA_TITLE);
        booksRepository = new BooksRepository();
        currentBook = booksRepository.getBook(title);
        title = currentBook.getName();
        content = currentBook.getContent();
        settingsActivated = false;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Book getCurrentBook() {
        return currentBook;
    }

    public boolean isSettingsActivated() {
        return settingsActivated;
    }

    public void setSettingsActivated(boolean settingsActivated) {
        this.settingsActivated = settingsActivated;
    }

    public MutableLiveData<Integer> getFontSize() {
        return fontSize;
    }

    public void setFontSize(MutableLiveData<Integer> fontSize) {
        this.fontSize = fontSize;
    }
}
