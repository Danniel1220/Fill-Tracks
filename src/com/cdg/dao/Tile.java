package com.cdg.dao;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {
    private final int width;
    private final int height;

    private final int positionX;
    private final int positionY;

    private final Rectangle rect;

    public Tile(int width, int height, int positionX, int positionY) {
        this.width = width;
        this.height = height;
        this.positionX = positionX;
        this.positionY = positionY;

        // Rectangle that is drawn using drawMe method.
        rect = new Rectangle();
        rect.setSize(width, height);
        rect.setLocation(positionX, positionY);
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
        g.fillRect(positionX, positionY, width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Rectangle getRect() {
        return rect;
    }
}
