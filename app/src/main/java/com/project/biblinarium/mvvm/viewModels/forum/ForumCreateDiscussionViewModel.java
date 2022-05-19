package com.project.biblinarium.mvvm.viewModels.forum;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Club;
import com.project.biblinarium.mvvm.models.Discussion;
import com.project.biblinarium.mvvm.repositories.ClubsRepository;
import com.project.biblinarium.mvvm.repositories.UserRepository;

import java.util.Arrays;

public class ForumCreateDiscussionViewModel extends ViewModel {

    ClubsRepository clubsRepository = new ClubsRepository();

    public void createDiscussion(String name, String firstMessage, Bundle bundle) {
        Club club = clubsRepository.getClub(bundle.getString("clubName"));

        Discussion discussion = new Discussion(club.getDiscussions().size(),
                name,
                UserRepository.getCurrentUser().getNickname(),
                firstMessage);

        club.getDiscussions().add(discussion);
        Log.d("xxx", String.valueOf(club.getDiscussions().size()));
    }
}
