package com.cdg.dao;

import java.awt.*;

public class Player {
    private int playerWidth;
    private int playerHeight;

    private int playerX;
    private int playerY;

    private Rectangle rect;

    public Player(int playerWidth, int playerHeight, int playerX, int playerY) {
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
        this.playerX = playerX;
        this.playerY = playerY;

        // Rectangle that is drawn using drawMe method.
        rect = new Rectangle();
        rect.setSize(playerWidth, playerHeight);
        rect.setLocation(playerX, playerY);
    }

    public void drawMe(Graphics2D g, Color color, boolean hasOutline) {
        // If hasOutline is true we set the stroke's thickness to 2, otherwise 0 for no outline.
        if (hasOutline) {
            g.setStroke(new BasicStroke(2));
        } else {
            g.setStroke(new BasicStroke(0));
        }
        // Outline is always white
        g.setColor(Color.WHITE);
        g.draw(rect);

        // Drawing the actual rectangle
        g.setColor(color);
        g.fillRect(playerX, playerY, playerWidth, playerHeight);
    }
}
