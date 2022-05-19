package com.project.biblinarium.mvvm.views.ui.pages.forum;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.forum.ForumCreateDiscussionViewModel;

public class ForumCreateDiscussionFragment extends Fragment {

    EditText nameEnter;
    EditText firstMessageEnter;
    Button back;
    Button doneCreation;

    ForumCreateDiscussionViewModel createDiscussionViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_create_discussion, container, false);

        nameEnter = view.findViewById(R.id.editText_fragment_forum_setDiscussionName);
        firstMessageEnter = view.findViewById(R.id.editText_fragment_forum_setDiscussionDescription);
        back = view.findViewById(R.id.button_fragment_forum_back);
        doneCreation = view.findViewById(R.id.button_fragment_forum_doneCreateDiscussion);

        createDiscussionViewModel = new ViewModelProvider(this).get(ForumCreateDiscussionViewModel.class);

        back.setOnClickListener(v -> {
            ForumFragment parent = (ForumFragment) getParentFragment();
            parent.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_forum_mainPanel,
                            parent.clubPageFragment.getClass(),
                            requireArguments())
                    .commit();
        });

        doneCreation.setOnClickListener(v -> {
            String name = nameEnter.getText().toString();
            String firstMessage = firstMessageEnter.getText().toString();
            createDiscussionViewModel.createDiscussion(name, firstMessage, requireArguments());

            ForumFragment parent = (ForumFragment) getParentFragment();
            parent.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_forum_mainPanel,
                            parent.clubPageFragment.getClass(),
                            requireArguments())
                    .commit();
        });

        return view;
    }
}