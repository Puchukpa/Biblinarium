package com.project.biblinarium.mvvm.viewModels.forum;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Club;
import com.project.biblinarium.mvvm.models.Discussion;
import com.project.biblinarium.mvvm.repositories.ClubsRepository;

public class ForumDiscussionButtonViewModel extends ViewModel {

    private String clubName;
    private int discussionId;
    private String discussionName;
    private String discussionReplies;
    private Bundle bundle;

    public String getClubName() {
        return clubName;
    }

    public int getDiscussionId() {
        return discussionId;
    }

    public String getDiscussionName() {
        return discussionName;
    }

    public String getDiscussionReplies() {
        return discussionReplies;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
        this.clubName = bundle.getString("clubName");
        this.discussionId = bundle.getInt("discussionId");
        Discussion discussion = new ClubsRepository().getClub(clubName).getDiscussions().get(discussionId);
        this.discussionName = discussion.getTheme();
        this.discussionReplies = String.valueOf(discussion.getReplies());
    }

    public Bundle getBundle() {
        return bundle;
    }
}
