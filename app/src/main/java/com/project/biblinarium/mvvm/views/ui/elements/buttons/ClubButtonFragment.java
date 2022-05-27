package com.project.biblinarium.mvvm.views.ui.elements.buttons;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.forum.ForumClubButtonViewModel;
import com.project.biblinarium.mvvm.views.activities.BookActivity;
import com.project.biblinarium.mvvm.views.ui.pages.books.BooksBookPageFragment;
import com.project.biblinarium.mvvm.views.ui.pages.books.BooksFragment;
import com.project.biblinarium.mvvm.views.ui.pages.forum.ForumClubPageFragment;
import com.project.biblinarium.mvvm.views.ui.pages.forum.ForumFragment;

public class ClubButtonFragment extends Fragment {

    TextView clubName;
    TextView clubTheme;
    TextView clubMembers;
    ImageView clubProfilePicture;
    Button clubButton;

    ForumClubButtonViewModel clubButtonViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_element_button_club_button, container, false);

        clubName = view.findViewById(R.id.textView_element_buttons_clubName);
        clubTheme = view.findViewById(R.id.textView_element_buttons_clubTheme);
        clubMembers = view.findViewById(R.id.textView_element_buttons_clubMembers);
        clubProfilePicture = view.findViewById(R.id.imageView_element_buttons_clubImage);
        clubButton = view.findViewById(R.id.button_fragment_forum_clubButton);

        clubButtonViewModel = new ViewModelProvider(this).get(ForumClubButtonViewModel.class);

        clubButtonViewModel.setBundle(requireArguments());

        clubName.setText(clubButtonViewModel.getClubName());
        clubTheme.setText(clubButtonViewModel.getClubTheme());
        clubMembers.setText("Members: " + clubButtonViewModel.getClubMembers());

        clubButton.setOnClickListener(v -> {
            Bundle bundle = clubButtonViewModel.getBundle();

            ForumFragment parentFragment = (ForumFragment) getParentFragment().getParentFragment();
            parentFragment
                    .getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_forum_mainPanel, ForumClubPageFragment.class, bundle)
                    .commit();
        });

        return view;
    }
}