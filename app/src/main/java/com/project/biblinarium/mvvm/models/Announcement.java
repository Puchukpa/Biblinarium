package com.project.biblinarium.mvvm.models;

public class Announcement {

    private String name;
    private String user;
    private String tags;
    private String address;
    private String contacts;
    private String description;

    public Announcement(String name, String user, String tags, String address, String contacts, String description) {
        this.name = name;
        this.user = user;
        this.tags = tags;
        this.address = address;
        this.contacts = contacts;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public String getTags() {
        return tags;
    }

    public String getAddress() {
        return address;
    }

    public String getContacts() {
        return contacts;
    }

    public String getDescription() {
        return description;
    }
}
