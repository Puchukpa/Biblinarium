package com.project.biblinarium.mvvm.models;

/**
 * Announcement class
 * @author Puchukpa
 * @version 1.0
 */
public class Announcement {

    /** Announcement name */
    private String name;

    /** Owner of announcement */
    private String user;

    /** Announcement tags */
    private String tags;

    /** Owner's address */
    private String address;

    /** Owner's contacts */
    private String contacts;

    /** Announcement description */
    private String description;

    /**
     * Class constructor. Sets initial values
     * @param name announcement name
     * @param user announcement owner
     * @param tags announcement tags
     * @param address owner's address
     * @param contacts owner's contacts
     * @param description announcement description
     */
    public Announcement(String name, String user, String tags, String address, String contacts, String description) {
        this.name = name;
        this.user = user;
        this.tags = tags;
        this.address = address;
        this.contacts = contacts;
        this.description = description;
    }

    /**
     * Returns field {@link Announcement#name}
     * @return announcement name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns field {@link Announcement#user}
     * @return announcement owner
     */
    public String getUser() {
        return user;
    }

    /**
     * Returns field {@link Announcement#tags}
     * @return announcement tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * Returns field {@link Announcement#address}
     * @return owner's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns field {@link Announcement#contacts}
     * @return owner's contacts
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * Returns field {@link Announcement#description}
     * @return announcement description
     */
    public String getDescription() {
        return description;
    }
}
