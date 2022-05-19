package com.project.biblinarium.mvvm.viewModels.exchange;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Announcement;
import com.project.biblinarium.mvvm.repositories.AnnouncementsRepository;
import com.project.biblinarium.mvvm.repositories.UserRepository;

public class ExchangeCreateAnnouncementViewModel extends ViewModel {

    public void createAnnouncement(String name, String tags, String address, String contacts, String description) {
        AnnouncementsRepository.addAnnouncement(name, UserRepository.getCurrentUser().getNickname(), tags, address, contacts, description);
    }
}
