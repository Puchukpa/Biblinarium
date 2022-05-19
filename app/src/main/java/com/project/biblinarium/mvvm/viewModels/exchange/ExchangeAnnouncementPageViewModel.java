package com.project.biblinarium.mvvm.viewModels.exchange;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class ExchangeAnnouncementPageViewModel extends ViewModel {

    private Bundle bundle;
    private String announcementName;
    private String announcementUser;
    private String announcementTags;
    private String announcementAddress;
    private String announcementContacts;
    private String announcementDescription;

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
        announcementName = bundle.getString("announcementName");
        announcementUser = bundle.getString("announcementUser");
        announcementTags = bundle.getString("announcementTags");
        announcementAddress = bundle.getString("announcementAddress");
        announcementContacts = bundle.getString("announcementContacts");
        announcementDescription = bundle.getString("announcementDescription");
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

    public String getAnnouncementAddress() {
        return announcementAddress;
    }

    public String getAnnouncementContacts() {
        return announcementContacts;
    }

    public String getAnnouncementDescription() {
        return announcementDescription;
    }

    public Bundle getBundle() {
        return bundle;
    }
}
