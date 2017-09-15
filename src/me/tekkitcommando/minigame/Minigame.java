package me.tekkitcommando.minigame;

import me.tekkitcommando.minigame.command.LevelCommand;
import me.tekkitcommando.minigame.command.ShopCommand;
import me.tekkitcommando.minigame.handler.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Copyright (c) Ethan Smith.
 */
public class Minigame extends JavaPlugin {

    public static Minigame instance;
    private static int gameTimerId;
    private Logger logger;
    private ScoreHandler scoreHandler = ScoreHandler.instance;

    @Override
    public void onEnable() {
        this.logger = getLogger();
        scoreHandler.registerBoard();
        registerEvents();
        registerCommands();
        EconomyHandler.setupEconomy();
        startGameTimer();
        logger.info("Bukkit Minigame - Enabled!");
    }

    @Override
    public void onDisable() {
        logger.info("Bukkit Minigame - Disabled!");
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new ScoreHandler(), this);
        getServer().getPluginManager().registerEvents(new ShopHandler(), this);
        getServer().getPluginManager().registerEvents(new GunHandler(), this);
    }

    private void registerCommands() {
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("level").setExecutor(new LevelCommand());
    }

    private void startGameTimer() {
        GameHandler.gameTimer = 30;
        gameTimerId = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new GameHandler(this), 20l, 20l);
    }

    private void stopGameTimer() {
        getServer().getScheduler().cancelTask(gameTimerId);
    }

    public void restartTimer() {
        stopGameTimer();
        startGameTimer();
    }
}
