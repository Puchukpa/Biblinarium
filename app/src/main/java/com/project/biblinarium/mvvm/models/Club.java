package com.project.biblinarium.mvvm.models;

import java.util.ArrayList;

public class Club {

    private final int id;
    private String name;
    private String theme;
    private int members;
    private String description;
    private static final ArrayList<Discussion> discussions = new ArrayList<>();

    public Club(int id, String name, String theme, String description) {
        this.id = id;
        this.name = name;
        this.theme = theme;
        this.members = 0;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Discussion> getDiscussions() {
        return discussions;
    }

    public void addDiscussion(Discussion discussion) {
        discussions.add(discussion);
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", theme='" + theme + '\'' +
                ", members=" + members +
                ", description='" + description + '\'' +
                '}';
    }
}
