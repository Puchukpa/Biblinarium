package com.project.biblinarium.mvvm.repositories;

import com.project.biblinarium.mvvm.models.Announcement;

import java.util.ArrayList;
import java.util.HashMap;

public class AnnouncementsRepository {

    private static final HashMap<String, Announcement> allAnnouncements = new HashMap<>();

    public static void init() {
        allAnnouncements.put("Announcement1", new Announcement("Announcement1", "Matt", "Tag1, Tag2", "Address1" , "PhoneNumber1", "Description1"));
        allAnnouncements.put("Announcement2", new Announcement( "Announcement2", "Cris", "Tag1, Tag2", "Address2", "PhoneNumber1", "Description2"));
        allAnnouncements.put("Announcement3", new Announcement( "Announcement3", "Anna", "Tag1, tag2, Tag3", "Address2", "PhoneNumber1", "Description3"));
        allAnnouncements.put("Announcement4", new Announcement( "Announcement4", "Susan", "Tag1", "Address2", "PhoneNumber1", "Description4"));
        allAnnouncements.put("Announcement5", new Announcement( "Announcement5", "Mary", "Tag1, Tag2", "Address2", "PhoneNumber1", "Description5"));
    }

    public static HashMap<String, Announcement> getAllAnnouncements() {
        return allAnnouncements;
    }

    public static Announcement getAnnouncement(String announcementName) {
        return allAnnouncements.get(announcementName);
    }

    public static void addAnnouncement(String name, String user, String tags, String address, String contacts, String description) {
        allAnnouncements.put(name, new Announcement(name, user, tags, address, contacts, description));
    }
}
