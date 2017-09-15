package me.tekkitcommando.minigame.state;

/**
 * Copyright (c) Ethan Smith.
 */
public enum GameState {

    LOBBY_STATE,
    INGAME_STATE,
    RESTARTING_STATE;

    private static GameState currentState;

    public static GameState getState() {
        return currentState;
    }

    public static void setState(GameState state) {
        currentState = state;
    }
}
