package com.project.biblinarium.mvvm.viewModels.forum;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Club;
import com.project.biblinarium.mvvm.models.Discussion;
import com.project.biblinarium.mvvm.repositories.ClubsRepository;
import com.project.biblinarium.mvvm.repositories.UserRepository;

import java.util.ArrayList;

public class ForumClubPageViewModel extends ViewModel {

    private ClubsRepository clubsRepository = new ClubsRepository();

    private String clubName;
    private String clubTheme;
    private String clubDescription;
    private String clubMembers;
    private Club club;
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

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
        this.clubName = bundle.getString("clubName");
        this.clubTheme = bundle.getString("clubTheme");
        this.clubDescription = bundle.getString("clubDescription");
        this.clubMembers = bundle.getString("clubMembers");
        this.club = new ClubsRepository().getClub(clubName);
        Log.d("xxx", club.toString());
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ArrayList<Bundle> getDiscussionBundles() {
        ArrayList<Bundle> bundles = new ArrayList<>();
        for (Discussion discussion : club.getDiscussions()) {
            Bundle bundle = new Bundle();
            bundle.putString("clubName", club.getName());
            bundle.putInt("discussionId", discussion.getId());
            bundles.add(bundle);
        }
        return bundles;
    }

    public void addClub() {
        Club club = clubsRepository.getClub(clubName);

        for (Club club1 : UserRepository.getCurrentUser().getUsersClubs()) {
            if (club1.getName().equals(club.getName())) {
                return;
            }
        }

        club.setMembers(club.getMembers() + 1);
        UserRepository.getCurrentUser().getUsersClubs().add(club);
    }
}
