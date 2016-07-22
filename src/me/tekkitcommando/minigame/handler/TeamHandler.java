package me.tekkitcommando.minigame.handler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Copyright (c) Ethan Smith.
 */
public class TeamHandler {

    private ArrayList<String> red = new ArrayList<>();
    private ArrayList<String> blue = new ArrayList<>();
    private static ArrayList<String> players = new ArrayList<>();

    public ArrayList<String> getRed() {
        return red;
    }

    public ArrayList<String> getBlue() {
        return blue;
    }

    public static ArrayList<String> getPlayers() {
        return players;
    }

    public void populateTeams() {

        for(Player player : Bukkit.getOnlinePlayers()) {
            players.add(player.getName());

            if(players.size() % 2 == 0)
                blue.add(player.getName());
            else
                red.add(player.getName());
        }
    }
}
