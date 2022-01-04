package com.cdg.game;

import com.cdg.dao.MovementDirection;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameManager implements KeyListener {
    JFrame frame;
    GameInstance gameInstance;

    public GameManager(JFrame frame) {
        this.frame = frame;

        // Set frame size.
        frame.setSize(975, 578);

        // Set key Listener
        frame.addKeyListener(this);

        // Creating an instance of the game and adding it to the frame.
        gameInstance = new GameInstance();
        frame.add(gameInstance);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                gameInstance.input(MovementDirection.UP);
                break;
            case KeyEvent.VK_DOWN:
                gameInstance.input(MovementDirection.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                gameInstance.input(MovementDirection.LEFT);
                break;
            case KeyEvent.VK_RIGHT :
                gameInstance.input(MovementDirection.RIGHT);
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
