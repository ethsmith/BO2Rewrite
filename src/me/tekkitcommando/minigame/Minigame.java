package me.tekkitcommando.minigame;

import me.tekkitcommando.minigame.command.ShopCommand;
import me.tekkitcommando.minigame.handler.GameHandler;
import me.tekkitcommando.minigame.handler.GunHandler;
import me.tekkitcommando.minigame.handler.ScoreHandler;
import me.tekkitcommando.minigame.handler.ShopHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Copyright (c) Ethan Smith.
 */
public class Minigame extends JavaPlugin {

    private static int gameTimerId;
    private Logger logger;
    private ScoreHandler scoreHandler = ScoreHandler.instance;

    @Override
    public void onEnable() {
        this.logger = getLogger();
        scoreHandler.registerBoard();
        registerEvents();
        registerCommands();
        startGameTimer();
        logger.info("Bukkit Minigame - Enabled!");
    }

    @Override
    public void onDisable() {
        logger.info("Bukkit Minigame - Disabled!");
    }

    private void registerEvents() {
        Bukkit.getServer().getPluginManager().registerEvents(new ScoreHandler(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ShopHandler(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GunHandler(),this);
    }

    private void registerCommands() {
        getCommand("shop").setExecutor(new ShopCommand());
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
