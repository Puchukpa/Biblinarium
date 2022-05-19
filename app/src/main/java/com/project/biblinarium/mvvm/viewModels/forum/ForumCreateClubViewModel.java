package com.project.biblinarium.mvvm.viewModels.forum;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Club;
import com.project.biblinarium.mvvm.repositories.ClubsRepository;
import com.project.biblinarium.mvvm.repositories.UserRepository;

public class ForumCreateClubViewModel extends ViewModel {

    public void createClub(String name, String theme, String description) {
        ClubsRepository clubsRepository = new ClubsRepository();
        clubsRepository.addClub(name, theme, description);
        UserRepository.getCurrentUser().getUsersClubs().add(clubsRepository.getClub(name));
    }
}
