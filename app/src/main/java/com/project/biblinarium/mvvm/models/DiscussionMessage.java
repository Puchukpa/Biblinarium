package com.project.biblinarium.mvvm.models;

/**
 * Discussion message class
 * @author Puchukpa
 * @version 1.0
 */
public class DiscussionMessage {

    /** Message's author */
    private String author;

    /** Message text */
    private String message;

    /**
     * Class constructor. Sets initial values
     * @param author message's author
     * @param message message text
     * */
    public DiscussionMessage(String author, String message) {
        this.author = author;
        this.message = message;
    }

    /**
     * Returns field {@link DiscussionMessage#author}
     * @return message's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns field {@link DiscussionMessage#message}
     * @return message text
     */
    public String getMessage() {
        return message;
    }
}
