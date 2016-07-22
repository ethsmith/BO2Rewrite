package me.tekkitcommando.minigame.handler;

import me.tekkitcommando.minigame.Minigame;
import me.tekkitcommando.minigame.state.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Copyright (c) Ethan Smith.
 */
public class GameHandler extends BukkitRunnable {

    private Minigame minigame;

    public GameHandler(Minigame game) {
        minigame = game;
    }

    public static int gameTimer;

    public void run() {

        if (gameTimer == 0) {
            if (!canStart()) {
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "[Block Ops 2] Came can't start... Restarting timer...");
                minigame.restartTimer();
                return;
            }
            gameStart();
        }

        if (gameTimer % 10 == 0 || gameTimer < 10) {
            Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Game starts in " + String.valueOf(gameTimer) + " seconds!");
        }

        gameTimer -= 1;
    }

    /*
    TODO: Spawn players at configured team spawn points.
    */
    private void gameStart() {
        GameState.setState(GameState.INGAME_STATE);
    }

    /*\
    TODO: Spawn players back at lobby and reset map + scoreboard
    */
    private void gameRestart() {
        GameState.setState(GameState.RESTARTING_STATE);
    }

    private boolean canStart() {
        if(TeamHandler.getPlayers().size() >= minigame.getConfig().getInt("minPlayers") && GameState.getState() == GameState.LOBBY_STATE) {
            return true;
        }
        return false;
    }
}
