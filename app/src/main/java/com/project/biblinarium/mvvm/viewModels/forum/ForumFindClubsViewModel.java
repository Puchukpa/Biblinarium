package com.project.biblinarium.mvvm.viewModels.forum;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Club;
import com.project.biblinarium.mvvm.repositories.ClubsRepository;
import com.project.biblinarium.mvvm.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class ForumFindClubsViewModel extends ViewModel {

    private ClubsRepository clubsRepository = new ClubsRepository();

    public ArrayList<Bundle> getClubsBundles() {
        ArrayList<Club> clubs = new ArrayList<>(clubsRepository.getAllClubs().values());
        ArrayList<Club> newClubs = new ArrayList<>();

        for (Club clubI : clubs) {
            newClubs.add(clubI);
            for (Club clubJ : UserRepository.getCurrentUser().getUsersClubs()) {
                if (clubI.getName().equals(clubJ.getName())) {
                    newClubs.remove(clubI);
                }
            }
        }

        ArrayList<Bundle> bundles = new ArrayList<>();
        for (Club club : newClubs) {
            Bundle bundle = new Bundle();
            bundle.putString("clubName", club.getName());
            bundle.putString("clubTheme", club.getTheme());
            bundle.putString("clubDescription", club.getDescription());
            bundle.putString("clubMembers", String.valueOf(club.getMembers()));
            bundle.putBoolean("isAdded", false);
            bundles.add(bundle);
        }

        return bundles;
    }
}
