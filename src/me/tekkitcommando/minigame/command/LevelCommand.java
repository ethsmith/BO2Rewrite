package me.tekkitcommando.minigame.command;

import me.tekkitcommando.minigame.handler.LevelHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright (c) Ethan Smith.
 */
public class LevelCommand implements CommandExecutor {

    private int level;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("level") && args.length == 0) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.RED + "Please specify a class.");
            } else {
                sender.sendMessage("Only a player can use this command.");
            }
        } else if(cmd.getName().equalsIgnoreCase("level") && args.length > 0) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                switch (args[0]) {
                    case "infantry":
                        level = LevelHandler.getInfantryLevel(player);
                        player.sendMessage(ChatColor.GREEN + "Infantry Level: " + level);
                        break;
                    case "sniper":
                        level = LevelHandler.getSniperLevel(player);
                        player.sendMessage(ChatColor.GREEN + "Sniper Level: " + level);
                        break;
                    case "assault":
                        level = LevelHandler.getAssaultLevel(player);
                        player.sendMessage(ChatColor.GREEN + "Assault Level: " + level);
                        break;
                    case "engineer":
                        level = LevelHandler.getEngineerLevel(player);
                        player.sendMessage(ChatColor.GREEN + "Engineer Level: " + level);
                        break;
                    case "arsonist":
                        level = LevelHandler.getArsonistLevel(player);
                        player.sendMessage(ChatColor.GREEN + "Arsonist Level: " + level);
                        break;
                    default:
                        player.sendMessage(ChatColor.RED + "[Block Ops 2] Please specify a VALID class");
                        break;
                }
            }
        }
        return true;
    }
}
