package me.tekkitcommando.minigame.handler;

import com.shampaggon.crackshot.CSUtility;
import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Copyright (c) Ethan Smith.
 */
public class GunHandler implements Listener {

    private static CSUtility cs;

    /*
    TODO: Set weapon damage based on class level
    TODO: Check which gun is being used and determine class based on that
    */
    @EventHandler
    public void onWeaponDamage(WeaponDamageEntityEvent e) {

    }
}
