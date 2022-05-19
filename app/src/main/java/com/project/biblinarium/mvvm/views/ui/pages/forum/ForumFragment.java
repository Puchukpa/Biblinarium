package com.project.biblinarium.mvvm.views.ui.pages.forum;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.biblinarium.R;

public class ForumFragment extends Fragment {

    ForumMyClubsFragment myClubsFragment;
    ForumFindClubsFragment findClubsFragment;
    ForumDiscussionPageFragment discussionPageFragment;
    ForumClubPageFragment clubPageFragment;
    ForumCreateClubFragment createClubFragment;
    ForumCreateDiscussionFragment createDiscussionFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_forum, container, false);

        myClubsFragment = new ForumMyClubsFragment();
        findClubsFragment = new ForumFindClubsFragment();
        discussionPageFragment = new ForumDiscussionPageFragment();
        clubPageFragment = new ForumClubPageFragment();
        createClubFragment = new ForumCreateClubFragment();
        createDiscussionFragment = new ForumCreateDiscussionFragment();

        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.layout_forum_mainPanel, myClubsFragment)
                .commit();

        return view;
    }
}