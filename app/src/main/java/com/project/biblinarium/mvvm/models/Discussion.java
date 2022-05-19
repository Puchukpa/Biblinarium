package com.project.biblinarium.mvvm.models;

import java.util.ArrayList;

public class Discussion {

    private int id;
    private int replies;
    private String theme;
    private String author;
    private String firstMessage;
    private ArrayList<DiscussionMessage> messages;

    public Discussion(int id, String theme, String author, String firstMessage) {
        this.id = id;
        this.replies = 1;
        this.theme = theme;
        this.author = author;
        this.firstMessage = firstMessage;
        this.messages = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFirstMessage() {
        return firstMessage;
    }

    public void setFirstMessage(String firstMessage) {
        this.firstMessage = firstMessage;
    }

    public ArrayList<DiscussionMessage> getMessages() {
        return messages;
    }

    public void addMessage(DiscussionMessage message) {
        this.messages.add(message);
    }
}
