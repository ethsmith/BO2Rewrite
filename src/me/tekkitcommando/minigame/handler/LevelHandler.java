package me.tekkitcommando.minigame.handler;

import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Copyright (c) Ethan Smith.
 */
public class LevelHandler {

    private static HashMap<Player, Integer> infantryLevels = new HashMap<>();
    private static HashMap<Player, Integer> sniperLevels = new HashMap<>();
    private static HashMap<Player, Integer> assaultLevels = new HashMap<>();
    private static HashMap<Player, Integer> engineerLevels = new HashMap<>();
    private static HashMap<Player, Integer> arsonistLevels = new HashMap<>();

    public int getInfantryLevel(Player player) {
        return infantryLevels.get(player);
    }

    private int getSniperLevel(Player player) {
        return sniperLevels.get(player);
    }

    private int getAssaultLevel(Player player) {
        return assaultLevels.get(player);
    }

    private int getEngineerLevel(Player player) {
        return engineerLevels.get(player);
    }

    private int getArsonistLevel(Player player) {
        return arsonistLevels.get(player);
    }

    public void setInfantryLevel(Player player, int level) {
        infantryLevels.replace(player, infantryLevels.get(player), level);
    }

    public void setSniperLevel(Player player, int level) {
        sniperLevels.replace(player, sniperLevels.get(player), level);
    }

    public void setAssaultLevel(Player player, int level) {
        assaultLevels.replace(player, assaultLevels.get(player), level);
    }

    public void setEngineerLevel(Player player, int level) {
        engineerLevels.replace(player, engineerLevels.get(player), level);
    }

    public void setArsonistLevel(Player player, int level) {
        arsonistLevels.replace(player, arsonistLevels.get(player), level);
    }


}
