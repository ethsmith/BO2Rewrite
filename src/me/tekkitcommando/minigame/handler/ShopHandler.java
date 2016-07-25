package me.tekkitcommando.minigame.handler;

import me.tekkitcommando.minigame.Minigame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Copyright (c) Ethan Smith.
 */
public class ShopHandler implements Listener {

    private Minigame game = Minigame.instance;

    public static void openShopGui(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Shop");

        ItemStack infantry = new ItemStack(Material.WOOD_SWORD);
        ItemStack sniper = new ItemStack(Material.STONE_SWORD);
        ItemStack assault = new ItemStack(Material.GOLD_SWORD);
        ItemStack engineer = new ItemStack(Material.IRON_SWORD);
        ItemStack arsonist = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta infantryMeta = infantry.getItemMeta();
        ItemMeta sniperMeta = sniper.getItemMeta();
        ItemMeta assaultMeta = assault.getItemMeta();
        ItemMeta engineerMeta = engineer.getItemMeta();
        ItemMeta arsonistMeta = arsonist.getItemMeta();

        infantryMeta.setDisplayName(ChatColor.GREEN + "Infantry");
        sniperMeta.setDisplayName(ChatColor.GREEN + "Sniper");
        assaultMeta.setDisplayName(ChatColor.GREEN + "Assault");
        engineerMeta.setDisplayName(ChatColor.GREEN + "Engineer");
        arsonistMeta.setDisplayName(ChatColor.GREEN + "Arsonist");

        infantry.setItemMeta(infantryMeta);
        sniper.setItemMeta(sniperMeta);
        assault.setItemMeta(assaultMeta);
        engineer.setItemMeta(engineerMeta);
        arsonist.setItemMeta(arsonistMeta);

        inv.setItem(11, infantry);
        inv.setItem(12, sniper);
        inv.setItem(13, assault);
        inv.setItem(14, engineer);
        inv.setItem(15, arsonist);

        player.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Shop")) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);

        if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
            player.closeInventory();
            return;
        }

         /*
         * TODO: Check for balance and allow upgrade purchases
         */
        switch (event.getCurrentItem().getType()) {
            case WOOD_SWORD:
                if(EconomyHandler.economy.has(player.getName(), game.getConfig().getInt("classes.infantry.price." + LevelHandler.getInfantryLevel(player) + 1))) {
                    EconomyHandler.economy.withdrawPlayer(player.getName(), game.getConfig().getInt("classes.infantry.price." + LevelHandler.getInfantryLevel(player) + 1));
                } else {
                    player.sendMessage(ChatColor.RED + "[Block Ops 2] You can't afford that upgrade.");
                }
                player.closeInventory();
                break;
            case STONE_SWORD:
                if(EconomyHandler.economy.has(player.getName(), game.getConfig().getInt("classes.assault.price." + LevelHandler.getAssaultLevel(player) + 1))) {
                    EconomyHandler.economy.withdrawPlayer(player.getName(), game.getConfig().getInt("classes.assault.price." + LevelHandler.getAssaultLevel(player) + 1));
                } else {
                    player.sendMessage(ChatColor.RED + "[Block Ops 2] You can't afford that upgrade.");
                }
                player.closeInventory();
                break;
            case GOLD_SWORD:
                if(EconomyHandler.economy.has(player.getName(), game.getConfig().getInt("classes.sniper.price." + LevelHandler.getSniperLevel(player) + 1))) {
                    EconomyHandler.economy.withdrawPlayer(player.getName(), game.getConfig().getInt("classes.sniper.price." + LevelHandler.getSniperLevel(player) + 1));
                } else {
                    player.sendMessage(ChatColor.RED + "[Block Ops 2] You can't afford that upgrade.");
                }
                player.closeInventory();
                break;
            case IRON_SWORD:
                if(EconomyHandler.economy.has(player.getName(), game.getConfig().getInt("classes.engineer.price." + LevelHandler.getEngineerLevel(player) + 1))) {
                    EconomyHandler.economy.withdrawPlayer(player.getName(), game.getConfig().getInt("classes.engineer.price." + LevelHandler.getEngineerLevel(player) + 1));
                } else {
                    player.sendMessage(ChatColor.RED + "[Block Ops 2] You can't afford that upgrade.");
                }
                player.closeInventory();
                break;
            case DIAMOND_SWORD:
                if(EconomyHandler.economy.has(player.getName(), game.getConfig().getInt("classes.arsonist.price." + LevelHandler.getArsonistLevel(player) + 1))) {
                    EconomyHandler.economy.withdrawPlayer(player.getName(), game.getConfig().getInt("classes.arsonist.price." + LevelHandler.getArsonistLevel(player) + 1));
                } else {
                    player.sendMessage(ChatColor.RED + "[Block Ops 2] You can't afford that upgrade.");
                }
                player.closeInventory();
                break;
            default:
                player.sendMessage(ChatColor.RED + "[Block Ops 2] That is not a valid upgrade!");
                player.closeInventory();
                break;
        }
    }
}
