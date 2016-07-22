package me.tekkitcommando.minigame.handler;

/**
 * Copyright (c) Ethan Smith.
 */
public enum ClassHandler {

    INFANTRY,
    SNIPER,
    ASSAULT,
    ENGINEER,
    ARSONIST;

    private static ClassHandler currentClass = INFANTRY;

    public static ClassHandler getCurrentClass() {
        return currentClass;
    }

    public static void setCurrentClass(ClassHandler prefClass) {
        currentClass = prefClass;
    }
}
