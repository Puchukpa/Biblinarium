package com.project.biblinarium.mvvm.repositories;

import com.project.biblinarium.mvvm.models.Book;
import com.project.biblinarium.mvvm.models.Club;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.HashMap;

public class ClubsRepository {

    private static final HashMap<String, Club> allClubs = new HashMap<>();
    private int lastUsedId = 5;

    public ClubsRepository() {
        allClubs.put("Club1", new Club(1, "Club1", "Theme1", "Description1"));
        allClubs.put("Club2", new Club(2, "Club2", "Theme2", "Description2"));
        allClubs.put("Club3", new Club(3, "Club3", "Theme3", "Description3"));
        allClubs.put("Club4", new Club(4, "Club4", "Theme4", "Description4"));
        allClubs.put("Club5", new Club(5, "Club5", "Theme5", "Description5"));
        allClubs.get("Club1").setMembers(2);
        allClubs.get("Club2").setMembers(2);
        allClubs.get("Club3").setMembers(2);
        allClubs.get("Club4").setMembers(2);
        allClubs.get("Club5").setMembers(2);
    }

    public HashMap<String, Club> getAllClubs() {
        return allClubs;
    }

    public ArrayList<Club> getSomeClubs(String[] clubs) {
        ArrayList<Club> someClubs = new ArrayList<>();
        for (String club : clubs) {
            someClubs.add(allClubs.get(club));
        }
        return someClubs;
    }

    public Club getClub(String clubName) {
        return allClubs.get(clubName);
    }

    public void addClub(String name, String theme, String description) {
        allClubs.put(name, new Club(++lastUsedId, name, theme, description));
    }
}
