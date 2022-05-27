package com.project.biblinarium.mvvm.models;

import java.util.ArrayList;

/**
 * Club class
 * @author Puchukpa
 * @version 1.0
 */
public class Club {

    /** Club ID */
    private final int id;

    /** Club's name */
    private String name;

    /** Club's theme */
    private String theme;

    /** Amount of members */
    private int members;

    /** Club's description */
    private String description;

    /** List of club's description */
    private static final ArrayList<Discussion> discussions = new ArrayList<>();

    /**
     * Class constructor. Sets initial values
     * @param id club ID
     * @param name club's name
     * @param theme club's theme
     * @param description club's description
     */
    public Club(int id, String name, String theme, String description) {
        this.id = id;
        this.name = name;
        this.theme = theme;
        this.members = 0;
        this.description = description;
    }

    /**
     * Returns field {@link Club#name}
     * @return club's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets field {@link Club#name}
     * @param name club's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns field {@link Club#theme}
     * @return club's theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets field {@link Club#theme}
     * @param  theme club's theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Returns field {@link Club#members}
     * @return amount of club's members
     */
    public int getMembers() {
        return members;
    }

    /**
     * Sets field {@link Club#members}
     * @param members amount of club's members
     */
    public void setMembers(int members) {
        this.members = members;
    }

    /**
     * Returns field {@link Club#description}
     * @return club's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description {@link Club#description}
     * @param description club's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns list of discussions of the club
     * @return list of discussions
     */
    public ArrayList<Discussion> getDiscussions() {
        return discussions;
    }

    /**
     * Adds new discussion to the discussion list
     * @param discussion discussion object
     */
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
