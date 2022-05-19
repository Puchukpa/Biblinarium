package com.project.biblinarium.mvvm.viewModels.forum;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Club;
import com.project.biblinarium.mvvm.repositories.UserRepository;

import java.util.ArrayList;

public class ForumMyClubsViewModel extends ViewModel {

    public ArrayList<Bundle> getClubsBundles() {
        ArrayList<Club> clubs = new ArrayList<>(UserRepository.getCurrentUser().getUsersClubs());

        ArrayList<Bundle> bundles = new ArrayList<>();
        for (Club club : clubs) {
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
