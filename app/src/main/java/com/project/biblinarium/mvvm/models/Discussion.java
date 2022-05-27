package com.project.biblinarium.mvvm.models;

import java.util.ArrayList;

/**
 * Discussion class
 * @author Puchukpa
 * @version 1.0
 */
public class Discussion {

    /** Discussion ID */
    private int id;

    /** Number of replies in discussion */
    private int replies;

    /** Discussion theme */
    private String theme;

    /** Discussion author */
    private String author;

    /** First message ib discussion */
    private String firstMessage;

    /** List of messages */
    private ArrayList<DiscussionMessage> messages;

    /**
     * Class constructor. Sets initial values
     * @param id discussion ID
     * @param theme discussion theme
     * @param author discussion author
     * @param firstMessage first message in discussion
     */
    public Discussion(int id, String theme, String author, String firstMessage) {
        this.id = id;
        this.replies = 1;
        this.theme = theme;
        this.author = author;
        this.firstMessage = firstMessage;
        this.messages = new ArrayList<>();
    }

    /**
     * Returns field {@link Discussion#id}
     * @return discussion id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns field {@link Discussion#replies}
     * @return number of replies
     */
    public int getReplies() {
        return replies;
    }

    /**
     * Returns field {@link Discussion#theme}
     * @return discussion theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Returns field {@link Discussion#author}
     * @return discussion author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns field {@link Discussion#firstMessage}
     * @return first message in discussion
     */
    public String getFirstMessage() {
        return firstMessage;
    }

    /**
     * Returns list of messages
     * @return list of messages
     */
    public ArrayList<DiscussionMessage> getMessages() {
        return messages;
    }

    /**
     * Adds new message to list of messages
     * @param message message object
     */
    public void addMessage(DiscussionMessage message) {
        this.messages.add(message);
    }
}
