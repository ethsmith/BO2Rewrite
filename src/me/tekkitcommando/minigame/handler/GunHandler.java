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
        if(e.getWeaponTitle().equalsIgnoreCase("carbine")) {
            setInfantryDamage(player);
        } else if(e.getWeaponTitle().equalsIgnoreCase("gauss")) {
            setAssaultDamage(player);
        }
    }

    private void setInfantryDamage(Player player) {
        e.setDamage((e.getDamage() + LevelHandler.getInfantryLevel(player)) - 1);
    }

    private void setAssaultDamage(Player player) {
        e.setDamage((e.getDamage() + LevelHandler.getAssaultLevel(player)) - 1);
    }
}
