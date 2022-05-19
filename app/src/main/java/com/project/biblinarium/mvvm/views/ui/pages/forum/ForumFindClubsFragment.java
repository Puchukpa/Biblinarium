package com.project.biblinarium.mvvm.views.ui.pages.forum;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.forum.ForumFindClubsViewModel;
import com.project.biblinarium.mvvm.viewModels.forum.ForumMyClubsViewModel;
import com.project.biblinarium.mvvm.views.ui.elements.SearchingLineElement;
import com.project.biblinarium.mvvm.views.ui.elements.buttons.BookButtonFragment;
import com.project.biblinarium.mvvm.views.ui.elements.buttons.ClubButtonFragment;

import java.util.ArrayList;

public class ForumFindClubsFragment extends Fragment {

    Button myClubsButton;

    ForumFindClubsViewModel findClubsViewModel;
    SearchingLineElement findClubsSearchingLineElement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_find_clubs, container, false);

        findClubsViewModel = new ViewModelProvider(this).get(ForumFindClubsViewModel.class);
        findClubsSearchingLineElement = new SearchingLineElement();

        myClubsButton = view.findViewById(R.id.button_fragment_forum_findClubs_myClubs);

        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_forum_findClubs_searchingPanel, findClubsSearchingLineElement)
                .commit();

        ArrayList<Bundle> bundles = findClubsViewModel.getClubsBundles();
        for (Bundle bundle : bundles) {
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.layout_fragment_forum_findClubs_findClubsButtons,
                            ClubButtonFragment.class,
                            bundle)
                    .commit();
        }

        myClubsButton.setOnClickListener(v -> {
            ForumFragment parentFragment = (ForumFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_forum_mainPanel, parentFragment.myClubsFragment)
                    .commit();
        });

        return view;
    }
}