package com.project.biblinarium.mvvm.views.ui.elements.buttons;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.forum.ForumDiscussionMessageViewModel;

import org.w3c.dom.Text;

public class DiscussionMessageFragment extends Fragment {

    TextView messageAuthor;
    TextView messageText;

    ForumDiscussionMessageViewModel discussionMessageViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_element_discussion_message, container, false);

        messageAuthor = view.findViewById(R.id.textView_fragment_forum_discussion_messageAuthor);
        messageText = view.findViewById(R.id.textView_fragment_forum_discussion_userMessage);

        discussionMessageViewModel = new ViewModelProvider(this).get(ForumDiscussionMessageViewModel.class);

        discussionMessageViewModel.setBundle(requireArguments());

        messageAuthor.setText(discussionMessageViewModel.getMessageAuthor());
        messageText.setText(discussionMessageViewModel.getMessageText());

        return view;
    }
}