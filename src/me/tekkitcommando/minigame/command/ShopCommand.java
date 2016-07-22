package me.tekkitcommando.minigame.command;

import me.tekkitcommando.minigame.handler.ShopHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright (c) Ethan Smith.
 */
public class ShopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("shop")) {
            if(sender instanceof Player) {
                ShopHandler.openShopGui((Player) sender);
            } else {
                sender.sendMessage("Only players can use the shop command!");
            }
        }
        return true;
    }
}
