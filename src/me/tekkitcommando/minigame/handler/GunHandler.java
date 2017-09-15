package me.tekkitcommando.minigame.handler;

import com.shampaggon.crackshot.CSUtility;
import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Copyright (c) Ethan Smith.
 */
public class GunHandler implements Listener {

    private static CSUtility cs;
    WeaponDamageEntityEvent e;

    /*
    TODO: Set weapon damage based on class level
    TODO: Check which gun is being used and determine class based on that
    */
    @EventHandler
    public void onWeaponDamage(WeaponDamageEntityEvent e) {
        Player player = (Player) e.getDamager();
        if (e.getWeaponTitle().equalsIgnoreCase("carbine")) {
            e.setDamage((e.getDamage() + LevelHandler.getInfantryLevel(player)) - 1);
        } else if (e.getWeaponTitle().equalsIgnoreCase("ak-47")) {
            e.setDamage((e.getDamage() + LevelHandler.getAssaultLevel(player)) - 1);
        } else if (e.getWeaponTitle().equalsIgnoreCase("hunting")) {
            e.setDamage((e.getDamage() + LevelHandler.getSniperLevel(player)) - 1);
        } else if (e.getWeaponTitle().equalsIgnoreCase("toaster")) {
            e.setDamage((e.getDamage() + LevelHandler.getArsonistLevel(player)) - 1);
        } else {
            e.setDamage((e.getDamage() + LevelHandler.getEngineerLevel(player)) - 1);
        }
    }
}
