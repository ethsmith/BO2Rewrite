package me.tekkitcommando.minigame;

import me.tekkitcommando.minigame.handler.ScoreHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Copyright (c) Ethan Smith.
 */
public class Minigame extends JavaPlugin {

    private Logger logger;
    private ScoreHandler scoreHandler = ScoreHandler.instance;

    @Override
    public void onEnable() {
        this.logger = getLogger();
        scoreHandler.registerBoard();
        registerEvents();
        logger.info("Bukkit Minigame - Enabled!");
    }

    @Override
    public void onDisable() {
        logger.info("Bukkit Minigame - Disabled!");
    }

    public void registerEvents() {
        Bukkit.getServer().getPluginManager().registerEvents(new ScoreHandler(), this);
    }
}
