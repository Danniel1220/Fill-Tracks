package com.cdg.game;

import com.cdg.io.InputManager;

import javax.swing.*;

public class GameManager {
    private InputManager inputManager;
    private LevelLayout levelLayout;

    JFrame frame;

    public GameManager(JFrame frame) {
        // Passing the reference of the frame so we can perform actions on it.
        this.frame = frame;

        inputManager = new InputManager();
        levelLayout = LevelLayout.getInstance();

        // Set the level layout in the singleton class.
        levelLayout.setLevelLayoutList(inputManager.readLevelLayout("Levels/1"));


        // Creating an instance of the game and adding it to the frame.
        GameInstance gameInstance = new GameInstance();
        frame.add(gameInstance);

        // Set frame size.
        frame.setSize(975, 578);
    }

    private void getLevelLayout() {

    }
}
