package com.project.biblinarium.mvvm.viewModels;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class BooksBookButtonViewModel extends ViewModel {

    private boolean isAdded;
    private String bookName;
    private String bookAuthor;
    private String bookDescription;
    private String bookSize;
    private Bundle bundle;

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public String getBookSize() {
        return bookSize;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
        this.bookName = bundle.getString("bookName");
        this.bookAuthor = bundle.getString("bookAuthor");
        this.bookDescription = bundle.getString("bookDescription");
        this.bookSize = bundle.getString("bookSize");
        this.isAdded = bundle.getBoolean("isAdded");
    }

    public Bundle getBundle() {
        return bundle;
    }
}
