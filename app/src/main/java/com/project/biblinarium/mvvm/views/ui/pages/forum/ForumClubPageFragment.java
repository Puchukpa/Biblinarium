package com.project.biblinarium.mvvm.views.ui.pages.forum;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.books.BooksBookPageViewModel;
import com.project.biblinarium.mvvm.viewModels.forum.ForumClubPageViewModel;
import com.project.biblinarium.mvvm.views.ui.elements.buttons.ClubButtonFragment;
import com.project.biblinarium.mvvm.views.ui.elements.buttons.DiscussionButtonFragment;
import com.project.biblinarium.mvvm.views.ui.pages.books.BooksFragment;

import java.util.ArrayList;

public class ForumClubPageFragment extends Fragment {

    TextView clubName;
    TextView clubTheme;
    TextView clubDescription;
    Button createDiscussion;
    FloatingActionButton back;
    FloatingActionButton subscribe;

    ForumClubPageViewModel clubPageViewModel;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_club_page, container, false);

        clubPageViewModel = new ViewModelProvider(this).get(ForumClubPageViewModel.class);

        clubPageViewModel.setBundle(requireArguments());

        clubName = view.findViewById(R.id.textView_fragment_forum_clubName);
        clubTheme = view.findViewById(R.id.textView_fragment_forum_clubPage_clubTheme);
        clubDescription = view.findViewById(R.id.textView_fragment_forum_clubPage_clubDescription);
        createDiscussion = view.findViewById(R.id.button_fragment_forum_createDiscussion);
        back = view.findViewById(R.id.floatingActionButton_fragment_forum_clubPage_back);
        subscribe = view.findViewById(R.id.floatingActionButton_fragment_forum_subscribe);

        clubName.setText(clubPageViewModel.getClubName());
        clubTheme.setText(clubPageViewModel.getClubTheme());
        clubDescription.setText(clubPageViewModel.getClubDescription());

        ArrayList<Bundle> discussionBundles = clubPageViewModel.getDiscussionBundles();
        for (Bundle bundle : discussionBundles) {
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.layout_fragment_forum_discussions,
                            DiscussionButtonFragment.class,
                            bundle)
                    .commit();
        }

        createDiscussion.setOnClickListener(v -> {
            ForumFragment parentFragment = (ForumFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_forum_mainPanel,
                            parentFragment.createDiscussionFragment.getClass(),
                            requireArguments())
                    .commit();
        });

        back.setOnClickListener(v -> {
            ForumFragment parentFragment = (ForumFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_forum_mainPanel, parentFragment.myClubsFragment)
                    .commit();
        });

        subscribe.setOnClickListener(v -> {
            clubPageViewModel.addClub();
        });
        
        return view;
    }
}