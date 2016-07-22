package me.tekkitcommando.minigame.handler;

import me.tekkitcommando.minigame.Minigame;
import me.tekkitcommando.minigame.state.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
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

    private void gameStart() {
        GameState.setState(GameState.INGAME_STATE);
        for(Player player : TeamHandler.getPlayers()) {
            Block redSpawn = Bukkit.getServer().getWorld("world").getBlockAt(410, 63, 223);
            Block blueSpawn = Bukkit.getServer().getWorld("world").getBlockAt(410, 63, 249);
            if(TeamHandler.getRed().contains(player.getName())) {
                if (redSpawn != null) {
                    player.teleport(redSpawn.getLocation());
                } else {
                    player.sendMessage(ChatColor.RED + "Couldn't find red team spawn. Please report this to an admin!");
                }
            } else {
                if (blueSpawn != null) {
                    player.teleport(blueSpawn.getLocation());
                } else {
                    player.sendMessage(ChatColor.RED + "Couldn't find blue team spawn. Please report this to an admin!");
                }
            }
        }
    }

    /*\
    TODO: Spawn players back at lobby and reset map + scoreboard
    */
    private void gameRestart() {
        GameState.setState(GameState.RESTARTING_STATE);
    }


    // Change to minigame.getConfig().getInt("minPlayers") soon.
    private boolean canStart() {
        return TeamHandler.getPlayers().size() >=  2 && GameState.getState() == GameState.LOBBY_STATE;
    }
}
