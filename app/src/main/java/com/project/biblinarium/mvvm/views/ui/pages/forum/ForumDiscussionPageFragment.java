package com.project.biblinarium.mvvm.views.ui.pages.forum;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.forum.ForumDiscussionPageViewModel;
import com.project.biblinarium.mvvm.views.ui.elements.buttons.DiscussionMessageFragment;

public class ForumDiscussionPageFragment extends Fragment {

    Button back;
    TextView firstMessageTheme;
    TextView firstMessageAuthor;
    TextView firstMessageText;
    EditText messageEnter;
    FloatingActionButton sendMessage;

    ForumDiscussionPageViewModel discussionPageViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_discussion_page, container, false);

        back = view.findViewById(R.id.button_fragment_forum_discussion_back);
        firstMessageTheme = view.findViewById(R.id.textView_fragment_forum_discussion_discussionTheme);
        firstMessageAuthor = view.findViewById(R.id.textView_fragment_forum_discussion_userNickname);
        firstMessageText = view.findViewById(R.id.textView_fragment_forum_discussion_message);
        messageEnter = view.findViewById(R.id.editText_fragment_forum_discussion_enterMessage);
        sendMessage = view.findViewById(R.id.floatingActionButton_fragment_forum_discussion_sendButton);

        discussionPageViewModel = new ViewModelProvider(this).get(ForumDiscussionPageViewModel.class);

        discussionPageViewModel.setBundle(requireArguments());

        firstMessageTheme.setText(discussionPageViewModel.getFirstMessageTheme());
        firstMessageAuthor.setText(discussionPageViewModel.getFirstMessageAuthor());
        firstMessageText.setText(discussionPageViewModel.getFirstMessageText());

        sendMessage.setOnClickListener(v -> {
            //
        });

        back.setOnClickListener(v -> {
            ForumFragment parent = (ForumFragment) getParentFragment();
            parent.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_forum_mainPanel,
                            parent.clubPageFragment.getClass(),
                            discussionPageViewModel.getParentClubPageBundle())
                    .commit();
        });

        return view;
    }
}