package me.tekkitcommando.minigame.handler;

import me.tekkitcommando.minigame.Minigame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

/**
 * Copyright (c) Ethan Smith.
 */
public class ConfigHandler {

    public static Player player = null;
    private static Minigame mg = Minigame.instance;

    /**
     * Setup config on first time use.
     */
    public void setupConfig(FileConfiguration config) throws IOException {
        if (!new File(mg.getDataFolder(), "config.yml").exists()) {
            new File(mg.getDataFolder(), "config.yml").createNewFile();
            config.set("options.minPlayers", 2);
            config.set("options.maxPlayers", 16);
            config.set("options.lobbyX", 1);
            config.set("options.lobbyY", 1);
            config.set("options.lobbyZ", 1);
            config.set("options.redX", 10);
            config.set("options.redY", 10);
            config.set("options.redZ", 10);
            config.set("options.blueX", 20);
            config.set("options.blueY", 20);
            config.set("options.blueZ", 20);
        }
    }

    /**
     * Reload config
     */
    public void reloadConfig() {
        mg.reloadConfig();
        player.sendMessage(ChatColor.GREEN + "[BlockOps] Config reloaded.");
    }

    /**
     * Update config with a String
     */
    public void updateConfig(String path, String value) {
        mg.getConfig().set(path, value);
        Bukkit.getServer().getLogger().info("[Block Ops] Updated config path " + path + " to " + value);
    }

    /**
     * Update config with a boolean
     */
    public void updateConfig(String path, boolean value) {
        mg.getConfig().set(path, value);
        Bukkit.getServer().getLogger().info("[Block Ops] Updated config path " + path + " to " + value);
    }

    /**
     * Update config with a int
     */
    public void updateConfig(String path, int value) {
        mg.getConfig().set(path, value);
        Bukkit.getServer().getLogger().info("[Block Ops] Updated config path " + path + " to " + value);
    }
}
