package com.project.biblinarium.mvvm.models;

public class Book {

    private int id;
    private String name;
    private String author;
    private String description;
    private int pages;
    private float readingProgress;
    private String content;
    private String[] tags;

    public Book(int id, String name, String author, String description, int pages, String content) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.pages = pages;
        this.readingProgress = 0;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public int getPages() {
        return pages;
    }

    public float getReadingProgress() {
        return readingProgress;
    }

    public String getContent() {
        return content;
    }

    public String[] getTags() {
        return tags;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReadingProgress(float readingProgress) {
        this.readingProgress = readingProgress;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
