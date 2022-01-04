package com.cdg.dao;

import javax.swing.*;
import java.awt.*;

public class Square extends JPanel {
    private final int squareWidth;
    private final int squareHeight;

    private final int squareX;
    private final int squareY;

    private final Rectangle rect;

    public Square(int squareWidth, int squareHeight, int squareX, int squareY) {
        this.squareWidth = squareWidth;
        this.squareHeight = squareHeight;
        this.squareX = squareX;
        this.squareY = squareY;

        // Rectangle that is drawn using drawMe method.
        rect = new Rectangle();
        rect.setSize(squareWidth, squareHeight);
        rect.setLocation(squareX, squareY);
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
        g.fillRect(squareX, squareY, squareWidth, squareHeight);
    }
}
