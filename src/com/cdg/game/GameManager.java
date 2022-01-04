package com.cdg.game;

import com.cdg.dao.MovementDirection;
import com.cdg.io.InputManager;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameManager implements KeyListener {
    private InputManager inputManager;
    private LevelLayout levelLayout;

    JFrame frame;
    GameInstance gameInstance;

    public GameManager(JFrame frame) {
        // Passing the reference of the frame so we can perform actions on it.
        this.frame = frame;

        inputManager = new InputManager();
        levelLayout = LevelLayout.getInstance();

        // Set the level layout in the singleton class.
        levelLayout.setLevelLayoutList(inputManager.readLevelLayout("Levels/1"));


        // Creating an instance of the game and adding it to the frame.
        gameInstance = new GameInstance();
        gameInstance.setFocusable(true);
        gameInstance.requestFocus();
        frame.add(gameInstance);


        // Set frame size.
        frame.setSize(975, 578);

        frame.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key was pressed");
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                gameInstance.sendInputToPlayer(MovementDirection.UP);
                break;
            case KeyEvent.VK_DOWN:
                gameInstance.sendInputToPlayer(MovementDirection.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                gameInstance.sendInputToPlayer(MovementDirection.LEFT);
                break;
            case KeyEvent.VK_RIGHT :
                gameInstance.sendInputToPlayer(MovementDirection.RIGHT);
                break;
        }
        System.out.println();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
