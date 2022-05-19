package com.project.biblinarium.mvvm.views.ui.pages.forum;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.forum.ForumCreateClubViewModel;

public class ForumCreateClubFragment extends Fragment {

    EditText nameEnter;
    EditText themeEnter;
    EditText descriptionEnter;
    Button back;
    Button doneCreation;

    ForumCreateClubViewModel createClubViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_create_club, container, false);

        nameEnter = view.findViewById(R.id.editText_fragment_forum_setClubName);
        themeEnter = view.findViewById(R.id.editText_fragment_forum_setClubTheme);
        descriptionEnter = view.findViewById(R.id.editText_fragment_forum_setClubDescription);
        back = view.findViewById(R.id.button_fragment_forum_back);
        doneCreation = view.findViewById(R.id.button_fragment_forum_doneCreateClub);

        createClubViewModel = new ViewModelProvider(this).get(ForumCreateClubViewModel.class);

        doneCreation.setOnClickListener(v -> {
            String name = nameEnter.getText().toString();
            String theme = themeEnter.getText().toString();
            String description = descriptionEnter.getText().toString();
            createClubViewModel.createClub(name, theme, description);

            ForumFragment parentFragment = (ForumFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_forum_mainPanel, parentFragment.myClubsFragment)
                    .commit();
        });

        back.setOnClickListener(v -> {
            ForumFragment parentFragment = (ForumFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_forum_mainPanel, parentFragment.myClubsFragment)
                    .commit();
        });

        return view;
    }
}