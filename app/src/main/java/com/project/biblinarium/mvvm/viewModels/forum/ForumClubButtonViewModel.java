package com.project.biblinarium.mvvm.viewModels.forum;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class ForumClubButtonViewModel extends ViewModel {

    private boolean isAdded;
    private String clubName;
    private String clubTheme;
    private String clubDescription;
    private String clubMembers;
    private Bundle bundle;

    public String getClubName() {
        return clubName;
    }

    public String getClubTheme() {
        return clubTheme;
    }

    public String getClubDescription() {
        return clubDescription;
    }

    public String getClubMembers() {
        return clubMembers;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
        this.clubName = bundle.getString("clubName");
        this.clubTheme = bundle.getString("clubTheme");
        this.clubDescription = bundle.getString("clubDescription");
        this.clubMembers = bundle.getString("clubMembers");
        this.isAdded = bundle.getBoolean("isAdded");
    }

    public Bundle getBundle() {
        return bundle;
    }
}
