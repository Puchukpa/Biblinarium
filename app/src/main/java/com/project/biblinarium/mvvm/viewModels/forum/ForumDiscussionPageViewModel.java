package com.project.biblinarium.mvvm.viewModels.forum;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Club;
import com.project.biblinarium.mvvm.models.Discussion;
import com.project.biblinarium.mvvm.models.DiscussionMessage;
import com.project.biblinarium.mvvm.repositories.ClubsRepository;
import com.project.biblinarium.mvvm.repositories.UserRepository;

import java.util.ArrayList;

public class ForumDiscussionPageViewModel extends ViewModel {

    private Discussion discussion;
    private Club club;
    private Bundle bundle;

    public String getFirstMessageTheme() {
        return discussion.getTheme();
    }

    public String getFirstMessageAuthor() {
        return discussion.getAuthor();
    }

    public String getFirstMessageText() {
        return discussion.getFirstMessage();
    };

    public void setBundle(Bundle bundle) {
        this.club = new ClubsRepository().getClub(bundle.getString("clubName"));
        this.discussion = club.getDiscussions().get(bundle.getInt("discussionId"));
    }

    public Bundle getParentClubPageBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("clubName", club.getName());
        bundle.putString("clubTheme", club.getTheme());
        bundle.putString("clubDescription", club.getDescription());
        bundle.putString("clubMembers", String.valueOf(club.getMembers()));
        return bundle;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ArrayList<DiscussionMessage> getDiscussionMessages() {
        return discussion.getMessages();
    }
    public void addDiscussionMessage(String message) {
        this.discussion.addMessage(new DiscussionMessage(UserRepository.getCurrentUser().getNickname(),
                message));
    }
}


