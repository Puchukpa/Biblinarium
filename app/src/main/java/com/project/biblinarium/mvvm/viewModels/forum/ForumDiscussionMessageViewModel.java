package com.project.biblinarium.mvvm.viewModels.forum;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.BuildConfig;

public class ForumDiscussionMessageViewModel extends ViewModel {

    private Bundle bundle;
    private String messageAuthor;
    private String messageText;

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
        messageAuthor = bundle.getString("messageAuthor");
        messageText = bundle.getString("messageText");
    }

    public Bundle getBundle() {
        return bundle;
    }

    public String getMessageAuthor() {
        return messageAuthor;
    }

    public String getMessageText() {
        return messageText;
    }
}
