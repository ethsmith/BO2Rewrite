package me.tekkitcommando.minigame.handler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;

/**
 * Copyright (c) Ethan Smith.
 */
public class ScoreHandler implements Listener {

    public static ScoreHandler instance;
    private static Scoreboard board;
    private static Objective o;
    private HashMap<OfflinePlayer, Score> scores = new HashMap<>();

    public void registerBoard() {
        board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();

        o = ScoreHandler.board.registerNewObjective("steps", "dummy");
        o.setDisplayName(ChatColor.GREEN + "Minigame");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        player.setScoreboard(board);

        scores.putIfAbsent(player, o.getScore(Bukkit.getServer().getOfflinePlayer(ChatColor.GREEN + "Kills:")));
    }

    @EventHandler
    public void onPlayerKill(EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null) {
            scores.get(e.getEntity().getKiller()).setScore(scores.get(e.getEntity().getKiller()).getScore() + 1);
        }
    }
}
