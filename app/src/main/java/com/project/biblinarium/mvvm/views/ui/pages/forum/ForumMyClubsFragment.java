package com.project.biblinarium.mvvm.views.ui.pages.forum;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.forum.ForumMyClubsViewModel;
import com.project.biblinarium.mvvm.views.ui.elements.SearchingLineElement;
import com.project.biblinarium.mvvm.views.ui.elements.buttons.BookButtonFragment;
import com.project.biblinarium.mvvm.views.ui.elements.buttons.ClubButtonFragment;

import java.util.ArrayList;

public class ForumMyClubsFragment extends Fragment {

    Button findClubsButton;
    Button createClub;

    ForumMyClubsViewModel myClubsViewModel;
    SearchingLineElement myClubsSearchingLineElement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_my_clubs, container, false);

        myClubsViewModel = new ViewModelProvider(this).get(ForumMyClubsViewModel.class);
        myClubsSearchingLineElement = new SearchingLineElement();

        findClubsButton = view.findViewById(R.id.button_fragment_forum_myClubs_findClubs);
        createClub = view.findViewById(R.id.button_fragment_forum_createClub);

        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_forum_myClubs_searchingPanel, myClubsSearchingLineElement)
                .commit();

        ArrayList<Bundle> clubsBundles = myClubsViewModel.getClubsBundles();
        for (Bundle bundle : clubsBundles) {
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.layout_fragment_forum_myClubs_myClubsButtons,
                            ClubButtonFragment.class,
                            bundle)
                    .commit();
        }

        findClubsButton.setOnClickListener(v -> {
            ForumFragment parentFragment = (ForumFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_forum_mainPanel, parentFragment.findClubsFragment)
                    .commit();
        });

        createClub.setOnClickListener(v -> {
            ForumFragment parentFragment = (ForumFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_forum_mainPanel, parentFragment.createClubFragment)
                    .commit();
        });

        return view;
    }
}