package com.project.biblinarium.mvvm.views.ui.elements.buttons;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.forum.ForumDiscussionButtonViewModel;
import com.project.biblinarium.mvvm.views.ui.pages.forum.ForumClubPageFragment;
import com.project.biblinarium.mvvm.views.ui.pages.forum.ForumDiscussionPageFragment;
import com.project.biblinarium.mvvm.views.ui.pages.forum.ForumFragment;

public class DiscussionButtonFragment extends Fragment {

    TextView discussionTheme;
    TextView discussionReplies;
    Button discussionButton;

    ForumDiscussionButtonViewModel discussionButtonViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_element_discussion_button, container, false);

        discussionTheme = view.findViewById(R.id.textView_element_forum_discussionTheme);
        discussionReplies = view.findViewById(R.id.textView_element_forum_discussion_replies);
        discussionButton = view.findViewById(R.id.button_fragment_forum_discussionButton);

        discussionButtonViewModel = new ViewModelProvider(this).get(ForumDiscussionButtonViewModel.class);

        discussionButtonViewModel.setBundle(requireArguments());

        discussionTheme.setText(discussionButtonViewModel.getDiscussionName());
        discussionReplies.setText(discussionButtonViewModel.getDiscussionReplies());

        discussionButton.setOnClickListener(v -> {
            Bundle bundle = discussionButtonViewModel.getBundle();

            ForumFragment parentFragment = (ForumFragment) getParentFragment().getParentFragment();
            parentFragment
                    .getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_forum_mainPanel,
                            ForumDiscussionPageFragment.class,
                            bundle)
                    .commit();
        });

        return view;
    }
}