package com.project.biblinarium.mvvm.viewModels.exchange;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Announcement;
import com.project.biblinarium.mvvm.models.Club;
import com.project.biblinarium.mvvm.repositories.AnnouncementsRepository;
import com.project.biblinarium.mvvm.repositories.UserRepository;

import java.util.ArrayList;

public class ExchangeFindBooksViewModel extends ViewModel {

    public ArrayList<Bundle> getAnnouncementsBundles() {
        ArrayList<Announcement> announcements = new ArrayList<>(AnnouncementsRepository.getAllAnnouncements().values());

        ArrayList<Bundle> bundles = new ArrayList<>();
        for (Announcement announcement : announcements) {
            Bundle bundle = new Bundle();
            bundle.putString("announcementName", announcement.getName());
            bundle.putString("announcementUser", announcement.getUser());
            bundle.putString("announcementTags", announcement.getTags());
            bundle.putString("announcementAddress", announcement.getAddress());
            bundle.putString("announcementContacts", announcement.getContacts());
            bundle.putString("announcementDescription", announcement.getDescription());
            bundles.add(bundle);
        }

        return bundles;
    }
}
