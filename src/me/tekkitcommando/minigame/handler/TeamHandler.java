package me.tekkitcommando.minigame.handler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Copyright (c) Ethan Smith.
 */
public class TeamHandler {

    private static ArrayList<String> red = new ArrayList<>();
    private static ArrayList<String> blue = new ArrayList<>();
    private static ArrayList<Player> players = new ArrayList<>();

    public static ArrayList<String> getRed() {
        return red;
    }

    public static ArrayList<String> getBlue() {
        return blue;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public void populateTeams() {

        for (Player player : Bukkit.getOnlinePlayers()) {
            players.add(player);

            if (players.size() % 2 == 0)
                blue.add(player.getName());
            else
                red.add(player.getName());
        }
    }
}
