package com.project.biblinarium.mvvm.models;

/**
 * Book class
 * @author Puchukpa
 * @version 1.0
 */
public class Book {

    /** Book ID */
    private int id;

    /** Book name */
    private String name;

    /** Book's author */
    private String author;

    /** Book's description */
    private String description;

    /** Amount of pages in the book */
    private int pages;

    /** Reading progress */
    private float readingProgress;

    /** Book's content' */
    private String content;

    /** Genre tags */
    private String[] tags;

    /**
     * Class constructor. Sets initial values
     * @param id book's ID
     * @param name book's name
     * @param author book's author
     * @param description book's description
     * @param pages amount of pages
     * @param content book's content
     */
    public Book(int id, String name, String author, String description, int pages, String content) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.pages = pages;
        this.readingProgress = 0;
        this.content = content;
    }

    /**
     * Returns field {@link Book#id}
     * @return book's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns field {@link Book#name}
     * @return book's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns field {@link Book#author}
     * @return book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns field {@link Book#description}
     * @return book's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns field {@link Book#pages}
     * @return amount of pages in the book
     */
    public int getPages() {
        return pages;
    }

    /**
     * Returns field {@link Book#readingProgress}
     * @return reading progress
     */
    public float getReadingProgress() {
        return readingProgress;
    }

    /**
     * Returns field {@link Book#content}
     * @return book's content
     */
    public String getContent() {
        return content;
    }

    /**
     * Returns field {@link Book#tags}
     * @return genre tags
     */
    public String[] getTags() {
        return tags;
    }

    /**
     * Sets field {@link Book#readingProgress}
     * @param readingProgress reading progress in percents (from 0 to 1)
     */
    public void setReadingProgress(float readingProgress) {
        this.readingProgress = readingProgress;
    }
}
