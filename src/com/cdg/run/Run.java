package com.cdg.run;

import com.cdg.game.GameInstance;
import com.cdg.game.GameManager;
import com.cdg.io.InputManager;

import javax.swing.*;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        JFrame frame;
        // Create the frame.
        frame = new JFrame("Fill Tracks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Show frame.
        frame.setVisible(true);

        // Creating a gameManager and passing the frame's reference to it.
        GameManager gameManager = new GameManager(frame);
    }
}
