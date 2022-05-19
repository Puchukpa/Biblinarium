package com.project.biblinarium.mvvm.viewModels.exchange;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class ExchangeAnnouncementButtonViewModel extends ViewModel {

    private Bundle bundle;
    private String announcementName;
    private String announcementUser;
    private String announcementTags;

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
        announcementName = bundle.getString("announcementName");
        announcementUser = bundle.getString("announcementUser");
        announcementTags = bundle.getString("announcementTags");
    }

    public String getAnnouncementName() {
        return announcementName;
    }

    public String getAnnouncementUser() {
        return announcementUser;
    }

    public String getAnnouncementTags() {
        return announcementTags;
    }

    public Bundle getBundle() {
        return bundle;
    }
}
