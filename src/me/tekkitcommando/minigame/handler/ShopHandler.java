package me.tekkitcommando.minigame.handler;

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
                player.closeInventory();
                break;
            case STONE_SWORD:
                player.closeInventory();
                break;
            case GOLD_SWORD:
                player.closeInventory();
                break;
            case IRON_SWORD:
                player.closeInventory();
                break;
            case DIAMOND_SWORD:
                player.closeInventory();
                break;
            default:
                player.closeInventory();
                break;
        }
    }
}
